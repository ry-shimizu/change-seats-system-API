package changeSeat.Service;

import changeSeat.Enum.EnumFlagType;
import changeSeat.Enum.EnumSexType;
import changeSeat.Error.Exception.FileOperateException;
import changeSeat.Error.Exception.InvalidInputException;
import changeSeat.Mapper.MyClassMapper;
import changeSeat.Mapper.SeatMapper;
import changeSeat.Mapper.StudentMapper;
import changeSeat.Model.MyClass.MyClass;
import changeSeat.Model.MyClass.MyClassDetail;
import changeSeat.Model.MyClass.MyClassList;
import changeSeat.Model.MyClass.Seat;
import changeSeat.Model.MyClass.Student;
import changeSeat.Model.MyClass.StudentForCsv;
import changeSeat.Request.MyClass.MyClassDeleteSeatRequest;
import changeSeat.Request.MyClass.MyClassUpdateSeatRequest;
import changeSeat.Request.MyClass.MycClassRegisterRequest;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MyClassService {

    private final MyClassMapper myClassMapper;

    private final SeatMapper seatMapper;

    private final StudentMapper studentMapper;

    public List<MyClassList> getMyClassList(int siteUserId) {
        return myClassMapper.getMyClassList(siteUserId);
    }

    public List<MyClassDetail> getMyClassDetail(int classId, int siteUserId) {
        return myClassMapper.getMyClassDetail(classId, siteUserId);
    }

    public void updateSeat(MyClassUpdateSeatRequest request, LocalDateTime now) {
        var overSeatNumbers = seatMapper.getOverSeatNumber(request.getClassId(), request.getSeatNumber());
        var targetDigits = request.getSeatNumber() / 10;
        var minDigits = targetDigits * 10;
        var maxDigits = ((targetDigits + 1) * 10) - 1;

        overSeatNumbers.stream()
                .filter(s -> minDigits < s.getSeatNumber() && s.getSeatNumber() <= maxDigits)
                .forEach(s -> seatMapper.updateSeatNumber(s.getSeatNumber() + 1, s.getSeatNumber(), s.getId(), request.getClassId(), now));

        try {
            var seat = Seat.builder()
                    .seatNumber(request.getSeatNumber())
                    .classId(request.getClassId())
                    .emptySeatFlg(request.isEmptySeat() ? EnumFlagType.FLAG_ON : EnumFlagType.FLAG_OFF)
                    .createdBy(request.getSiteUserId())
                    .createdDt(now)
                    .updatedBy(request.getSiteUserId())
                    .updatedDt(now)
                    .build();
            seatMapper.insertSeat(seat);
            studentMapper.insertStudent(Student.builder()
                    .seatId(seat.getId())
                    .studentName(request.isEmptySeat() ? null : request.getStudentName())
                    .sexType(request.isEmptySeat() ? EnumSexType.OTHER : request.getSexType())
                    .createdBy(request.getSiteUserId())
                    .createdDt(now)
                    .updatedBy(request.getSiteUserId())
                    .updatedDt(now)
                    .build());
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("データの登録に失敗しました。再度お試しください。", e.getCause());
        }
    }

    public void deleteSeat(MyClassDeleteSeatRequest request, LocalDateTime now) {
        if (request.isEmptySeat()) {
            seatMapper.updateSeatToEmpty(request.getSeatId(), request.getClassId(), now);
            studentMapper.updateStudentToEmpty(request.getStudentId());
        } else {
            var overSeatNumbers = seatMapper.getOverSeatNumber(request.getClassId(), request.getSeatNumber());
            var targetDigits = request.getSeatNumber() / 10;
            var minDigits = targetDigits * 10;
            var maxDigits = ((targetDigits + 1) * 10) - 1;

            overSeatNumbers.stream()
                    .filter(s -> minDigits < s.getSeatNumber() && s.getSeatNumber() <= maxDigits)
                    .forEach(s -> seatMapper.updateSeatNumber(s.getSeatNumber() - 1, s.getSeatNumber(), s.getId(), request.getClassId(), now));

            seatMapper.deleteSeat(request.getSeatId());
            studentMapper.deleteStudent(request.getStudentId());
        }
    }

    public void registerMyClass(MultipartFile multipartFile, MycClassRegisterRequest request, LocalDateTime now) {
        List<StudentForCsv> studentsList;
        File temp = null;
        try (var bufferedInput = new BufferedInputStream(multipartFile.getInputStream());) {
            temp = File.createTempFile("temp_csv", ".csv");

            try (var bufferedOutput = new BufferedOutputStream(new FileOutputStream(temp));) {
                bufferedOutput.write(bufferedInput.readAllBytes());
            }
            try (var csvReader = new CSVReader(new FileReader(temp))) {
                var builder = new CsvToBeanBuilder<StudentForCsv>(csvReader);
                builder.withType(StudentForCsv.class);
                studentsList = builder.build().parse();
            }

            if (studentsList.size() != request.getSeatNumberList().size()) {
                throw new InvalidInputException("入力された生徒数と座席数が一致しません。");
            }

            var myClass = MyClass.builder()
                    .className(request.getClassName())
                    .classYear(request.getYear())
                    .title(request.getTitle())
                    .seatStartPoint(request.getSeatStartPoint())
                    .siteUserId(request.getSiteUserId())
                    .createdBy(request.getSiteUserId())
                    .createdDt(now)
                    .updatedBy(request.getSiteUserId())
                    .updatedDt(now)
                    .build();
            myClassMapper.insert(myClass);

            var count = new AtomicInteger(1);
            var studentCount = new AtomicInteger(1);
            request.getSeatNumberList().forEach((s) -> {
                for (int i = 1; i <= s.getSeatNum(); i++) {
                    var seatNum = Integer.parseInt(String.valueOf(count) + String.valueOf(i));
                    try {
                        var seat = Seat.builder()
                                .seatNumber(seatNum)
                                .classId(myClass.getId())
                                .emptySeatFlg(EnumFlagType.FLAG_OFF)
                                .createdBy(request.getSiteUserId())
                                .createdDt(now)
                                .updatedBy(request.getSiteUserId())
                                .updatedDt(now)
                                .build();
                        seatMapper.insertSeat(seat);

                        studentMapper.insertStudent(Student.builder()
                                .seatId(seat.getId())
                                .studentName(studentsList.get(Integer.parseInt(String.valueOf(studentCount)) - 1).getStudentName())
                                .sexType(EnumSexType.getEnumSexType(Integer.parseInt(studentsList.get(Integer.parseInt(String.valueOf(studentCount)) - 1).getSexType())))
                                .createdBy(request.getSiteUserId())
                                .createdDt(now)
                                .updatedBy(request.getSiteUserId())
                                .updatedDt(now)
                                .build());
                        studentCount.getAndIncrement();
                    } catch (DuplicateKeyException e) {
                        throw new DuplicateKeyException("データの登録に失敗しました。再度お試しください。", e.getCause());
                    }
                }
                count.getAndIncrement();
            });
        } catch (IOException e) {
            throw new FileOperateException("ファイル操作で問題が発生しました。", e.getCause());
        } finally {
            if (!Objects.isNull(temp)) {
                temp.deleteOnExit();
            }
        }
    }
}

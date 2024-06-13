package changeSeat.Service;

import changeSeat.Enum.EnumFlagType;
import changeSeat.Enum.EnumSexType;
import changeSeat.Error.Exception.FileOperateException;
import changeSeat.Error.Exception.InvalidInputException;
import changeSeat.Error.Exception.NotFoundException;
import changeSeat.Mapper.MyClassMapper;
import changeSeat.Mapper.SeatMapper;
import changeSeat.Mapper.StudentMapper;
import changeSeat.Model.MyClass.MyClass;
import changeSeat.Model.MyClass.MyClassDetail;
import changeSeat.Model.MyClass.MyClassList;
import changeSeat.Model.MyClass.Seat;
import changeSeat.Model.MyClass.Student;
import changeSeat.Model.MyClass.StudentForCsv;
import changeSeat.Model.MyClass.StudentSeatInfo;
import changeSeat.Request.MyClass.MyClassUpdateRequest;
import changeSeat.Request.MyClass.MycClassRegisterRequest;
import changeSeat.Request.MyClass.Seat.MyClassChangeSeatRequest;
import changeSeat.Request.MyClass.Seat.MyClassDeleteSeatRequest;
import changeSeat.Request.MyClass.Seat.MyClassRegisterSeatRequest;
import changeSeat.Request.MyClass.Seat.MyClassUpdateSeatRequest;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

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

    public List<MyClassDetail> getMyClassDetail(int classId, int siteUserId, int schoolId) {
        var myClassDetail = myClassMapper.getMyClassDetail(classId, siteUserId, schoolId);

        if (myClassDetail.size() == 0) {
            throw new NotFoundException(String.format("classId：%d、schoolId:%dのクラスは存在しません。", classId, schoolId));
        }

        return myClassDetail;
    }

    public void updateMyClass(MyClassUpdateRequest request, LocalDateTime now) {
        myClassMapper.updateMyClassInfo(request, now);
    }

    public void deleteMyClass(int classId, int schoolId, int siteUserId, LocalDateTime now) {
        myClassMapper.updateDeleteFlg(classId, schoolId, siteUserId, now);
    }

    public void registerSeat(MyClassRegisterSeatRequest request, LocalDateTime now) {
        var overSeatNumbers = seatMapper.getOverSeatNumber(request.getClassId(), request.getSeatNumber());
        var targetDigits = request.getSeatNumber() / 10;
        var minDigits = targetDigits * 10;
        var maxDigits = ((targetDigits + 1) * 10) - 1;

        overSeatNumbers.stream()
                .filter(s -> minDigits < s.getSeatNumber() && s.getSeatNumber() <= maxDigits)
                .forEach(s -> seatMapper.updateSeatNumber(s.getSeatNumber() + 1, s.getSeatNumber(), s.getSeatId(), request.getClassId(), now));

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

    public void updateSeat(MyClassUpdateSeatRequest request, LocalDateTime now) {
        if (request.isEmptySeat()) {
            seatMapper.updateEmptySeatFlg(request.getSeatId(), request.getClassId(), now, "FLAG_ON", request.getSiteUserId());
            studentMapper.updateStudent(request.getStudentId(), null, EnumSexType.OTHER, now, request.getSiteUserId());
        } else {
            seatMapper.updateEmptySeatFlg(request.getSeatId(), request.getClassId(), now, "FLAG_OFF", request.getSiteUserId());
            studentMapper.updateStudent(request.getStudentId(), request.getStudentName(), request.getSexType(), now, request.getSiteUserId());
        }
    }

    public void deleteSeat(MyClassDeleteSeatRequest request, LocalDateTime now) {
        var overSeatNumbers = seatMapper.getOverSeatNumber(request.getClassId(), request.getSeatNumber());
        var targetDigits = request.getSeatNumber() / 10;
        var minDigits = targetDigits * 10;
        var maxDigits = ((targetDigits + 1) * 10) - 1;

        overSeatNumbers.stream()
                .filter(s -> minDigits < s.getSeatNumber() && s.getSeatNumber() <= maxDigits)
                .forEach(s -> seatMapper.updateSeatNumber(s.getSeatNumber() - 1, s.getSeatNumber(), s.getSeatId(), request.getClassId(), now));
        studentMapper.deleteStudent(request.getStudentId());
        seatMapper.deleteSeat(request.getSeatId());
    }

    public List<MyClassDetail> changeSeat(MyClassChangeSeatRequest request, LocalDateTime now) {
        var studentSeatInfoList = studentMapper.getStudentSeatInfo(request.getClassId());
        var seatNumberList = new ArrayList<>(studentSeatInfoList.stream().map(StudentSeatInfo::getSeatNumber).toList());
        Collections.shuffle(seatNumberList);

        if (request.getChangeSeatConditionList().size() > 0) {
            var maxY = seatNumberList.stream().map(s -> s % 10).max(Integer::compare).orElseThrow(() -> new InvalidInputException("座席が存在しません。"));

            var maxX = seatNumberList.stream().map(s -> s / 10).max(Integer::compare).orElseThrow(() -> new InvalidInputException("座席が存在しません。"));

            var studentSeatInfoChangeList = new ArrayList<StudentSeatInfo>();
            request.getChangeSeatConditionList()
                    .forEach(c -> {
                        var seatNumberChangeList = new ArrayList<Integer>();
                        var seatNumberNotChangeList = new ArrayList<Integer>();

                        if (!Objects.isNull(c.getPositionYColumn()) && Objects.equals(c.getConditionY().getValue(), "3")) {
                            seatNumberList.stream().filter(s -> s % 10 <= c.getPositionYColumn()).forEach(seatNumberChangeList::add);
                        }

                        if (!Objects.isNull(c.getPositionYColumn()) && Objects.equals(c.getConditionY().getValue(), "4")) {
                            seatNumberList.stream().filter(s -> s % 10 > maxY - c.getPositionYColumn()).forEach(seatNumberChangeList::add);
                        }

                        if (!Objects.isNull(c.getPositionXColumn()) && Objects.equals(c.getConditionX().getValue(), "1")) {
                            if (seatNumberChangeList.size() > 0) {
                                seatNumberChangeList.stream()
                                        .filter(s -> Objects.equals(request.getEnumSeatStartPoint().getValue(), "2")
                                                ? s / 10 <= maxX - c.getPositionXColumn()
                                                : !Objects.equals(request.getEnumSeatStartPoint().getValue(), "1") || s / 10 > c.getPositionXColumn()).forEach(seatNumberNotChangeList::add);
                            } else {
                                seatNumberList.stream().filter(s -> Objects.equals(request.getEnumSeatStartPoint().getValue(), "2")
                                        ? s / 10 >= maxX - c.getPositionXColumn()
                                        : !Objects.equals(request.getEnumSeatStartPoint().getValue(), "1") || s / 10 <= c.getPositionXColumn()).forEach(seatNumberChangeList::add);
                            }
                        }

                        if (!Objects.isNull(c.getPositionXColumn()) && Objects.equals(c.getConditionX().getValue(), "2")) {
                            if (seatNumberChangeList.size() > 0) {
                                seatNumberChangeList.stream()
                                        .filter(s -> Objects.equals(request.getEnumSeatStartPoint().getValue(), "2")
                                                ? s / 10 > c.getPositionXColumn()
                                                : !Objects.equals(request.getEnumSeatStartPoint().getValue(), "1") || s / 10 <= maxX - c.getPositionXColumn()).forEach(seatNumberNotChangeList::add);
                            } else {
                                seatNumberList.stream().filter(s -> Objects.equals(request.getEnumSeatStartPoint().getValue(), "2")
                                        ? s / 10 <= c.getPositionXColumn()
                                        : !Objects.equals(request.getEnumSeatStartPoint().getValue(), "1") || s / 10 >= maxX - c.getPositionXColumn()).forEach(seatNumberChangeList::add);
                            }
                        }
                        var result = seatNumberChangeList.stream()
                                .filter(num -> !seatNumberNotChangeList.contains(num))
                                .toList();

                        if (result.size() == 0) {
                            throw new InvalidInputException("席替え条件の指定範囲に誤りがあります。");
                        }

                        var changedSeatNumber = result.get(new Random().nextInt(result.size()));
                        seatNumberList.removeIf(s -> s.intValue() == changedSeatNumber.intValue());
                        seatNumberList.add(changedSeatNumber);
                        studentSeatInfoList.removeIf(s -> s.getStudentId() == c.getStudentId());

                        studentSeatInfoChangeList.add(StudentSeatInfo.builder()
                                .seatId(c.getSeatId())
                                .studentId(c.getStudentId())
                                .seatNumber(changedSeatNumber)
                                .build());
                    });
            studentSeatInfoList.addAll(studentSeatInfoChangeList);
        }

        IntStream.range(0, studentSeatInfoList.size()).forEach(i -> {
            seatMapper.updateSeatNumberById(studentSeatInfoList.get(i).getSeatId(), request.getClassId(), seatNumberList.get(i), now);
        });

        return myClassMapper.getMyClassDetail(request.getClassId(), request.getSiteUserId(), request.getSchoolId());
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

            if (studentsList.size() != request.getSeatNumberList().stream().mapToInt(MycClassRegisterRequest.SeatNumber::getSeatNum).sum()) {
                throw new InvalidInputException("入力された生徒数と座席数が一致しません。");
            }

            var myClass = MyClass.builder()
                    .className(request.getClassName())
                    .classYear(request.getYear())
                    .title(request.getTitle())
                    .seatStartPoint(request.getSeatStartPoint())
                    .schoolId(request.getSchoolId())
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
                                .sexType(EnumSexType.getEnumSexType(studentsList.get(Integer.parseInt(String.valueOf(studentCount)) - 1).getSexType()))
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

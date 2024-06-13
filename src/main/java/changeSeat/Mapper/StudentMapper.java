package changeSeat.Mapper;

import changeSeat.Enum.EnumSexType;
import changeSeat.Model.MyClass.Student;
import changeSeat.Model.MyClass.StudentSeatInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("""
            INSERT INTO students(
              id,
              student_name,
              sex_type,
              seat_id,
              delete_flg,
              created_by,
              created_dt,
              updated_by,
              updated_dt)
            VALUES (
              nextval('student_seq'),
              #{studentName},
              #{sexType},
              #{seatId},
              'FLAG_OFF',
              #{createdBy},
              #{createdDt},
              #{updatedBy},
              #{updatedDt})
            """)
    void insertStudent(Student student);

    @Delete("""
            DELETE
            FROM
              students
            WHERE
              id = #{studentId}
            """)
    void deleteStudent(int studentId);

    @Update("""
            UPDATE
              students
            SET
              student_name = #{studentName},
              sex_type = #{sexType},
              updated_dt = #{now},
              updated_by = #{siteUserId}
            WHERE
              id = #{studentId}
            """)
    void updateStudent(int studentId, String studentName, EnumSexType sexType, LocalDateTime now, int siteUserId);

    @Select("""
            SELECT
              s.id as seat_id,
              s.seat_number,
              st.id as student_id
            FROM
              seats s
            INNER JOIN students st
            ON s.id = st.seat_id
            AND st.delete_flg = 'FLAG_OFF'
            WHERE
              s.class_id = #{classId}
              AND s.empty_seat_flg = 'FLAG_OFF'
              AND s.delete_flg = 'FLAG_OFF'
            """)
    List<StudentSeatInfo> getStudentSeatInfo(int classId);
}

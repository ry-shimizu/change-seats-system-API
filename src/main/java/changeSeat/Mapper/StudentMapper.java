package changeSeat.Mapper;

import changeSeat.Model.MyClass.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

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
              student_name = null,
              sex_type = 3
            WHERE
              id = #{studentId}
            """)
    void updateStudentToEmpty(int studentId);
}

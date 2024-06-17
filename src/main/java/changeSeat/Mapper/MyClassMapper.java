package changeSeat.Mapper;

import changeSeat.Model.MyClass.MyClass;
import changeSeat.Model.MyClass.MyClassDetail;
import changeSeat.Model.MyClass.MyClassList;
import changeSeat.Request.MyClass.MyClassUpdateRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MyClassMapper {

    @Select("""
            SELECT
              c.id AS classId,
              c.class_year,
              c.class_name,
              c.title,
              c.updated_dt,
              COUNT(s.id) AS student_num
            FROM
              classes c
            INNER JOIN seats s
            ON c.id = s.class_id
            AND s.delete_flg = 'FLAG_OFF'
            AND s.empty_seat_flg = 'FLAG_OFF'
            WHERE
              c.site_user_id = #{siteUserId}
              AND c.delete_flg = 'FLAG_OFF'
            GROUP BY
              c.class_year,
              c.class_name,
              c.title,
              c.updated_dt
            """)
    List<MyClassList> getMyClassList(int siteUserId);

    @Select("""
            SELECT
              c.class_year,
              c.class_name,
              c.title,
              c.seat_start_point,
              s.id as seat_id,
              s.seat_number,
              s.empty_seat_flg,
              stu.student_name,
              stu.sex_type,
              stu.id as student_id
            FROM
              classes c
            INNER JOIN seats s
            ON c.id = s.class_id
            AND s.delete_flg = 'FLAG_OFF'
            INNER JOIN students stu
            ON s.id = stu.seat_id
            AND stu.delete_flg = 'FLAG_OFF'
            WHERE
              c.id = #{classId}
              AND c.site_user_id = #{siteUserId}
              AND c.school_id = #{schoolId}
              AND c.delete_flg = 'FLAG_OFF'
            ORDER BY
              s.seat_number
            """)
    List<MyClassDetail> getMyClassDetail(int classId, int siteUserId, int schoolId);

    @Insert("""
            INSERT INTO classes(
              id,
              class_name,
              title,
              class_year,
              seat_start_point,
              site_user_id,
              school_id,
              delete_flg,
              created_by,
              created_dt,
              updated_by,
              updated_dt)
            VALUES (
              nextval('class_seq'),
              #{className},
              #{title},
              #{classYear},
              #{seatStartPoint},
              #{schoolId},
              #{siteUserId},
              'FLAG_OFF',
              #{createdBy},
              #{createdDt},
              #{updatedBy},
              #{updatedDt})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(MyClass myclass);

    @Update("""
            Update
              classes
            SET
              updated_by = #{siteUserId},
              updated_dt = #{now},
              delete_flg = 'FLAG_ON'
            WHERE
              id = #{classId}
              AND school_id = #{schoolId}
              AND site_user_id = #{siteUserId}
            """)
    void updateDeleteFlg(int classId, int schoolId, int siteUserId, LocalDateTime now);

    @Update("""
            Update
              classes
            SET
              title = #{request.title},
              class_year = #{request.classYear},
              class_name = #{request.className},
              updated_by = #{request.siteUserId},
              updated_dt = #{now}
            WHERE
              id = #{request.classId}
              AND school_id = #{request.schoolId}
              AND site_user_id = #{request.siteUserId}
            """)
    void updateMyClassInfo(@Param("request") MyClassUpdateRequest request, @Param("now") LocalDateTime now);
}

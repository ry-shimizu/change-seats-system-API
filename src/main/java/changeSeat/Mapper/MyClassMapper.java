package changeSeat.Mapper;

import changeSeat.Model.MyClass.MyClass;
import changeSeat.Model.MyClass.MyClassDetail;
import changeSeat.Model.MyClass.MyClassList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyClassMapper {

    @Select("""
            SELECT
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
              c.class_name,
              c.title,
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
              AND c.delete_flg = 'FLAG_OFF'
            """)
    List<MyClassDetail> getMyClassDetail(int classId, int siteUserId);

    @Insert("""
            INSERT INTO classes(
              id,
              class_name,
              title,
              class_year,
              seat_start_point,
              site_user_id,
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
              #{siteUserId},
              'FLAG_OFF',
              #{createdBy},
              #{createdDt},
              #{updatedBy},
              #{updatedDt})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(MyClass myclass);
}

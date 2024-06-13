package changeSeat.Mapper;

import changeSeat.Model.OtherClass.OtherClassDetail;
import changeSeat.Model.OtherClass.OtherClassList;
import changeSeat.Model.OtherClass.OtherClassRegister;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OtherClassMapper {

    @Select("""
            SELECT
              c.id AS classId,
              c.class_year,
              c.class_name,
              c.title,
              c.updated_dt,
              COUNT(s.id) AS student_num
            FROM
              other_classes oc
            INNER JOIN classes c
            ON oc.class_id = c.id
            AND c.delete_flg = 'FLAG_OFF'
            INNER JOIN seats s
            ON c.id = s.class_id
            AND s.delete_flg = 'FLAG_OFF'
            AND s.empty_seat_flg = 'FLAG_OFF'
            WHERE
              oc.site_user_id = #{siteUserId}
              AND oc.delete_flg = 'FLAG_OFF'
            GROUP BY
              c.id,
              c.class_year,
              c.class_name,
              c.title,
              c.updated_dt
            """)
    List<OtherClassList> getMyOtherClassList(int siteUserId);

    @Select("""
            <script>
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
              <if test="schoolId != null">
                AND c.school_id = #{schoolId}
              </if>
              WHERE
                c.delete_flg = 'FLAG_OFF'
              AND c.site_user_id != #{siteUserId}
              <if test="classYear != null">
                AND c.class_year = #{classYear}
              </if>
              <if test="className != null and className != ''">
                AND c.class_name LIKE CONCAT('%', #{className}, '%')
              </if>
              <if test="title != null and title != ''">
                AND c.title LIKE CONCAT('%', #{title}, '%')
              </if>
              GROUP BY
                c.class_year,
                c.class_name,
                c.title,
                c.updated_dt
            </script>
            """)
    List<OtherClassList> getOtherClassList(Integer classYear, String className, String title, int siteUserId, Integer schoolId);

    @Insert("""
            INSERT INTO other_classes (
              id,
              site_user_id,
              class_id,
              delete_flg,
              created_by,
              created_dt,
              updated_by,
              updated_dt)
            VALUES(
              nextval('other_class_seq'),
              #{siteUserId},
              #{classId},
              'FLAG_OFF',
              #{createdBy},
              #{createdDt},
              #{updatedBy},
              #{updatedDt})
            """)
    void insert(OtherClassRegister otherClassRegister);

    @Update("""
            UPDATE
              other_classes
            SET
              updated_by = #{siteUserId},
              updated_dt = #{now},
              delete_flg = 'FLAG_ON'
            WHERE
              class_id = #{classId}
              AND site_user_id = #{siteUserId}
            """)
    void updateDeleteFlg(int classId, int siteUserId, LocalDateTime now);

    @Select("""
            SELECT
              c.class_name,
              c.title,
              s.seat_number,
              s.empty_seat_flg,
              stu.student_name,
              stu.sex_type
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
              AND c.school_id = #{schoolId}
              AND c.delete_flg = 'FLAG_OFF'
            ORDER BY s.seat_number
            """)
    List<OtherClassDetail> getOtherClassDetail(int classId, int schoolId);

    @Select("""
            SELECT
              CASE
                COUNT(id)
              WHEN 0 THEN false
              ELSE true
              END
            FROM
              other_classes
            WHERE
              id = #{classId}
              AND site_user_id = #{siteUserId}
              AND delete_flg = 'FLAG_OFF'
            """)
    boolean checkMyOtherClass(int classId, int siteUserId);
}

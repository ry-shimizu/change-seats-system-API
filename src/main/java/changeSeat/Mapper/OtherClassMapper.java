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
              c.class_year,
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
            AND c.delete_flg = 'FLAG_OFF'
            WHERE
              oc.site_user_id = #{siteUserId}
              AND oc.delete_flg = 'FLAG_OFF'
            GROUP BY
              c.class_year,
              c.title,
              c.updated_dt
            """)
    List<OtherClassList> getMyOtherClassList(int siteUserId);

    @Select("""
            <script>
              SELECT
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
              AND c.delete_flg = 'FLAG_OFF'
              WHERE
                oc.delete_flg = 'FLAG_OFF'
              <if test="classYear != null">
                AND c.class_year = #{classYear}
              </if>
              <if test="className != null and className != ''">
                AND c.class_name = #{className}
              </if>
              <if test="title != null and className != ''">
                AND c.title = #{title}
              </if>
              GROUP BY
                c.class_year,
                c.class_name,
                c.title,
                c.updated_dt
            </script>
            """)
    List<OtherClassList> getOtherClassList(Integer classYear, String className, String title);

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
              delete_flg = 1
            WHERE
              id = #{otherClassId}
            """)
    void updateDeleteFlg(int otherClassId, int siteUserId, LocalDateTime now);

    @Select("""
            SELECT
              c.class_name,
              c.title,
              s.seat_number,
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
              AND c.delete_flg = 'FLAG_OFF'
            """)
    List<OtherClassDetail> getOtherClassDetail(int classId);

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

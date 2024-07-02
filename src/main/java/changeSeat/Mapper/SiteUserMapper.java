package changeSeat.Mapper;

import changeSeat.Enum.EnumAuthority;
import changeSeat.Model.SiteUser.SiteUserDetail;
import changeSeat.Model.SiteUser.SiteUserRegister;
import changeSeat.Model.SiteUser.SiteUserUpdate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SiteUserMapper {

    @Select("""
              <script>
                SELECT
                    su.id,
                    su.login_id,
                    su.user_name,
                    su.authority,
                    su.delete_flg,
                    s.school_name
                FROM
                  site_users su
                INNER JOIN schools s
                ON su.school_id = s.id
                AND s.delete_flg = 'FLAG_OFF'
                <if test="schoolName != null">
                  AND s.school_name LIKE CONCAT('%', #{schoolName}, '%')
                </if>
                <if test="!isAdmin ">
                  AND s.id = #{schoolId}
                </if>
                WHERE
                  su.delete_flg = 'FLAG_OFF'
                  <if test="loginId != null">
                    AND su.login_id LIKE CONCAT('%', #{loginId}, '%')
                  </if>
                  <if test="userName != null">
                    AND su.user_name LIKE CONCAT('%', #{userName}, '%')
                  </if>
                  <if test="authority != null and authority.size > 0">
                    AND su.authority IN
                    <foreach item="item" index="index" collection="authority" open="(" separator="," close=")">
                      #{item}
                    </foreach>
                  </if>
              </script>
            """)
    List<SiteUserDetail> getSiteUserList(String loginId, String userName, String schoolName, List<EnumAuthority> authority, boolean isAdmin, int schoolId);

    @Insert("""
                INSERT INTO site_users(
                  id,
                  login_id,
                  user_name,
                  authority,
                  password,
                  school_id,
                  delete_flg,
                  created_by,
                  created_dt,
                  updated_by,
                  updated_dt)
                VALUES(
                  nextval('site_user_seq'),
                  #{loginId},
                  #{userName},
                  #{authority},
                  #{password},
                  #{schoolId},
                  'FLAG_OFF',
                  #{createdBy},
                  #{createdDt},
                  #{updatedBy},
                  #{updatedDt})
            """)
    void insert(SiteUserRegister siteUser);

    @Select("""
              <script>
                SELECT
                  id,
                  school_id,
                  authority,
                  password
                FROM
                  site_users
                WHERE
                  login_id = #{loginId}
                  AND delete_flg = 'FLAG_OFF'
                  <if test="updateSiteUserId != null">
                    AND id != #{updateSiteUserId}
                  </if>
                </script>
            """)
    SiteUserDetail checkDuplicateLoginId(String loginId, Integer updateSiteUserId);

    @Select("""
              SELECT
                  su.id,
                  su.login_id,
                  su.user_name,
                  su.authority,
                  su.delete_flg,
                  s.id AS schoolId
              FROM
                site_users su
              INNER JOIN schools s
              ON su.school_id = s.id
              AND s.delete_flg = 'FLAG_OFF'
              WHERE
                su.id = #{id}
                AND su.delete_flg = 'FLAG_OFF'
            """)
    SiteUserDetail getSiteUserDetail(int id);

    @Update("""
            <script>
              UPDATE
                site_users
              SET
                login_id = #{loginId},
                user_name = #{userName},
                authority = #{authority},
                school_id = #{schoolId},
                <if test="password != null">
                  password = #{password},
                </if>
                updated_by = #{updatedBy},
                updated_dt = #{updatedDt}
              WHERE
                id = #{updateSiteUserId}
            </script>
            """)
    void update(SiteUserUpdate siteUserUpdate);

    @Update("""
            UPDATE
              site_users
            SET
              updated_by = #{siteUserId},
              updated_dt = #{now},
              delete_flg = 'FLAG_ON'
            WHERE
              id = #{id}
            """)
    void updateDeleteFlg(int id, int siteUserId, LocalDateTime now);
}

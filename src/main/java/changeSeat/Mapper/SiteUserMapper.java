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
                    id,
                    login_id,
                    user_name,
                    authority,
                    delete_flg
                FROM
                  site_users
                WHERE
                  delete_flg = 'FLAG_OFF'
                  <if test="loginId != null">
                    AND login_id LIKE CONCAT('%', #{loginId}, '%')
                  </if>
                  <if test="userName != null">
                    AND user_name LIKE CONCAT('%', #{userName}, '%')
                  </if>
                  <if test="authority != null and authority.size > 0">
                    AND authority IN
                    <foreach item="item" index="index" collection="authority" open="(" separator="," close=")">
                      #{item}
                    </foreach>
                  </if>
              </script>
            """)
    List<SiteUserDetail> getSiteUserList(String loginId, String userName, List<EnumAuthority> authority);

    @Insert("""
                INSERT INTO site_users(
                  id,
                  login_id,
                  user_name,
                  authority,
                  password,
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
                  'FLAG_OFF',
                  #{createdBy},
                  #{createdDt},
                  #{updatedBy},
                  #{updatedDt})
            """)
    void insert(SiteUserRegister siteUser);

    @Select("""
              SELECT
                count(*)
              FROM
                site_users
              WHERE
                login_id = #{loginId}
                AND password = #{password}
                AND delete_flg = 'FLAG_OFF'
            """)
    int checkDuplicateCertification(String loginId, String password);

    @Select("""
              SELECT
                  id,
                  login_id,
                  user_name,
                  authority,
                  delete_flg
              FROM
                site_users
              WHERE
                id = #{id}
                AND delete_flg = 'FLAG_OFF'
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
                <if test="password != null">
                  password = #{password},
                </if>
                updated_by = #{updatedBy},
                updated_dt = #{updatedDt}
              WHERE
                id = #{id}
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

package changeSeat.Mapper;

import changeSeat.Model.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("""
            SELECT
              id AS site_user_id,
              school_id,
              authority
            FROM
              site_users
            WHERE
              login_id = #{loginId}
              AND password = #{password}
            """)
    LoginUser login(String loginId, String password);
}

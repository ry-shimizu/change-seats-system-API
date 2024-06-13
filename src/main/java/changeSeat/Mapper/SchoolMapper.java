package changeSeat.Mapper;

import changeSeat.Model.School.School;
import changeSeat.Model.School.SchoolDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolMapper {

    @Insert("""
                INSERT INTO schools(
                  id,
                  school_name,
                  delete_flg,
                  created_by,
                  created_dt,
                  updated_by,
                  updated_dt)
                VALUES(
                  nextval('school_seq'),
                  #{schoolName},
                  'FLAG_OFF',
                  #{createdBy},
                  #{createdDt},
                  #{updatedBy},
                  #{updatedDt})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertSchool(School school);

    @Select("""
              SELECT
                id,
                school_name
              FROM
                schools
              WHERE
                delete_flg = 'FLAG_OFF'
            """)
    List<SchoolDetail> getSchoolList();
}

package changeSeat.Mapper;

import changeSeat.Model.MyClass.OverSeatNumInfo;
import changeSeat.Model.MyClass.Seat;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SeatMapper {
    @Insert("""
            INSERT INTO seats(
              id,
              seat_number,
              class_id,
              empty_seat_flg,
              delete_flg,
              created_by,
              created_dt,
              updated_by,
              updated_dt)
            VALUES (
              nextval('seat_seq'),
              #{seatNumber},
              #{classId},
              #{emptySeatFlg},
              'FLAG_OFF',
              #{createdBy},
              #{createdDt},
              #{updatedBy},
              #{updatedDt})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertSeat(Seat seat);

    @Select("""
            SELECT
              id,
              seat_number
            FROM
              seats
            WHERE
              class_id = #{classId}
              AND seat_number >= #{seatNumber}
              AND delete_flg = 'FLAG_OFF'
            """)
    List<OverSeatNumInfo> getOverSeatNumber(int classId, int seatNumber);

    @Update("""
              UPDATE
                seats
              SET
                seat_number = #{seatNumberCalculate},
                updated_dt = #{now}
              WHERE
                class_id = #{classId}
                AND id = #{seatId}
                AND seat_number = #{seatNumber}
                AND delete_flg = 'FLAG_OFF'
            """)
    void updateSeatNumber(int seatNumberCalculate, int seatNumber, int seatId, int classId, LocalDateTime now);

    @Delete("""
            DELETE
            FROM
              seats
            WHERE
              id=#{seatId}
            """)
    void deleteSeat(int seatId);

    @Update("""
              UPDATE
                seats
              SET
                empty_seat_flg = 1,
                updated_dt = #{now}
              WHERE
                class_id = #{classId}
                AND id = #{seatId}
                AND delete_flg = 'FLAG_OFF'
            """)
    void updateSeatToEmpty(int SeatId, int classId, LocalDateTime now);
}

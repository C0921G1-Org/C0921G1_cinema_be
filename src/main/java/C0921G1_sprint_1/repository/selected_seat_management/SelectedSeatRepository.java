package C0921G1_sprint_1.repository.selected_seat_management;

import C0921G1_sprint_1.model.seat.SelectedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SelectedSeatRepository extends JpaRepository<SelectedSeat, Integer> {



    /*DatTC - Query lấy dữ liệu ghế đã chọn theo showTimeId*/
    @Query(value = "SELECT * FROM selected_seat WHERE show_time_id = :id", nativeQuery = true)
    List<SelectedSeat> getAllByShowTimeId(@Param("id") String id);

}

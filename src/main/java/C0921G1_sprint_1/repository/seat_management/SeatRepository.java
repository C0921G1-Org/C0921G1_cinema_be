package C0921G1_sprint_1.repository.seat_management;

import C0921G1_sprint_1.model.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    /*DatTC*/
    @Query(value = "SELECT * FROM seat", nativeQuery = true)
    Set<Seat> getAll();

    @Query(value = "SELECT * FROM seat LEFT JOIN ticket ON seat.id = ticket.seat_id LEFT JOIN `transaction` ON `transaction`.id = ticket.transaction_id LEFT JOIN seat_type ON seat_type.id = seat.seat_type_id WHERE show_time_id LIKE :id", nativeQuery = true)
    Set<Seat> getAllByShowTimeId(@Param("id") String id);
}

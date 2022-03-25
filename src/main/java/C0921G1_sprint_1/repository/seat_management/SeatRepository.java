package C0921G1_sprint_1.repository.seat_management;

import C0921G1_sprint_1.model.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    /*DatTC*/
    @Query(value = "SELECT * FROM seat", nativeQuery = true)
    Set<Seat> getAll();
}

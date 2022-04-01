package C0921G1_sprint_1.repository.seat_type;

import C0921G1_sprint_1.model.seat.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {
    /*DatTC - Query lấy loại ghế theo id*/
    @Query(value = "SELECT * FROM seat_type WHERE id = :id", nativeQuery = true)
    Optional<SeatType> findById (@Param("id") Integer id);
}

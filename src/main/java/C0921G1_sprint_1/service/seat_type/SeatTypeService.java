package C0921G1_sprint_1.service.seat_type;

import C0921G1_sprint_1.model.seat.SeatType;

import java.util.Optional;

public interface SeatTypeService {
    Optional<SeatType> findById(Integer id);
}

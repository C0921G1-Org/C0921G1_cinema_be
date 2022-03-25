package C0921G1_sprint_1.service.seat_management;

import C0921G1_sprint_1.model.seat.Seat;
import C0921G1_sprint_1.repository.seat_management.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    private SeatRepository seatRepository;
    @Override
    public Set<Seat> getAll() {
        return seatRepository.getAll();
    }
}

package C0921G1_sprint_1.service.seat_type;

import C0921G1_sprint_1.model.seat.SeatType;
import C0921G1_sprint_1.repository.seat_type.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {
    @Autowired
    private SeatTypeRepository seatTypeRepository;
    @Override
    public Optional<SeatType> findById(Integer id) {
        return seatTypeRepository.findById(id);
    }
}

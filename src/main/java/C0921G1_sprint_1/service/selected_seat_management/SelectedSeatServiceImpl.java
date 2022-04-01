package C0921G1_sprint_1.service.selected_seat_management;

import C0921G1_sprint_1.model.seat.SelectedSeat;
import C0921G1_sprint_1.repository.selected_seat_management.SelectedSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedSeatServiceImpl implements SelectedSeatService {
    @Autowired
    private SelectedSeatRepository selectedSeatRepository;

    @Override
    public List<SelectedSeat> getAllByShowTimeId(String id) {
        return selectedSeatRepository.getAllByShowTimeId(id);
    }
}

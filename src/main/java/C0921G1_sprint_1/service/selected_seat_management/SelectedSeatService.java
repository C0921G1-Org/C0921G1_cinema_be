package C0921G1_sprint_1.service.selected_seat_management;

import C0921G1_sprint_1.model.seat.SelectedSeat;

import java.util.List;

public interface SelectedSeatService {
    List<SelectedSeat> getAllByShowTimeId(String id);
}

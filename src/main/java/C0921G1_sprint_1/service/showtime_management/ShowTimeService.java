package C0921G1_sprint_1.service.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;

import java.util.List;

public interface ShowTimeService {
    List<ShowTime> getAllByFilmId(String id);
}

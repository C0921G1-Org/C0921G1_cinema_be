package C0921G1_sprint_1.service.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;

import java.util.List;
import java.util.Optional;

public interface ShowTimeService {
    List<ShowTime> getAllByFilmId(Integer id, String date);
    List<ShowTime> getAllShowTime();
    Optional<ShowTime> findById(Integer id);}

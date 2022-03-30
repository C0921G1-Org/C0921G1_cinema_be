package C0921G1_sprint_1.service.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.repository.showtime_management.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {
    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Override
    public List<ShowTime> getAllByFilmId(Integer id, String date) {
        return showTimeRepository.getAllByFilmId(id, date);
    }

    @Override
    public List<ShowTime> getAllShowTime() {
        return showTimeRepository.getAllShowTime();
    }

    @Override
    public Optional<ShowTime> findById(Integer id) {
        return this.showTimeRepository.findById(id);
    }
}

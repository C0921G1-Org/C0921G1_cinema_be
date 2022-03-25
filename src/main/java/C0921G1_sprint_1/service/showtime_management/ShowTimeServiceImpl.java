package C0921G1_sprint_1.service.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.repository.showtime_management.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowTimeServiceImpl implements ShowTimeService {
    @Autowired
    private ShowTimeRepository showTimeRepository;
    @Override
    public List<ShowTime> getAllByFilmId(Integer id) {
        return showTimeRepository.getAllByFilmId(id);
    }
}

package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopFilm;
import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.repository.statistic_management.StatisticFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticFilmServiceImpl implements StatisticFilmService {
    @Autowired
    private StatisticFilmRepository repository;

    @Override
    public List<Film> findAllTopFilm() {
        return repository.findAllTopFilm();
    }
}

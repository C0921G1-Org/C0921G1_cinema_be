package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopFilm;

import java.util.List;

public interface StatisticFilmService {
    List<TopFilm> findAllTopFilm();
}

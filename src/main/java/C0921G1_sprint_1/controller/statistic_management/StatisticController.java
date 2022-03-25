package C0921G1_sprint_1.controller.statistic_management;


import C0921G1_sprint_1.dto.statistic.TopFilm;
import C0921G1_sprint_1.service.statistic_management.StatisticFilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private StatisticFilmServiceImpl statisticFilmService;

    @GetMapping("")
    void getAllTopFilm() {
        for (int i = 0; i <statisticFilmService.findAllTopFilm().length ; i++) {
            System.out.println(statisticFilmService.findAllTopFilm()[i]);
        }
    }
}

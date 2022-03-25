package C0921G1_sprint_1.controller.statistic_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.service.statistic_management.StatisticFilmServiceImpl;
import C0921G1_sprint_1.service.statistic_management.StatisticMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private StatisticFilmServiceImpl statisticFilmService;
    @Autowired
    private StatisticMemberServiceImpl statisticMemberService;

    //    @GetMapping("/film")
//    void getAllTopFilm() {
////        for (int i = 0; i <statisticFilmService.findAllTopFilm().length ; i++) {
////            System.out.println(statisticFilmService.findAllTopFilm()[i]);
////        }
//    }
//    @GetMapping("/member")
//    void getAllTopMember() {
////        for (int i = 0; i <statisticFilmService.findAllTopFilm().length ; i++) {
////            System.out.println(statisticFilmService.findAllTopFilm()[i]);
////        }
//    }
    @GetMapping("/film")
    public ResponseEntity<List<Film>> getAllTopFilm() {
        List<Film> topFilmList = statisticFilmService.findAllTopFilm();
        if (topFilmList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(topFilmList, HttpStatus.OK);
    }

    @GetMapping("member")
    public ResponseEntity<List<Member>> getAllTopMember() {
        List<Member> topMemberList = statisticMemberService.findAllTopMember();
        if (topMemberList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(topMemberList, HttpStatus.OK);
    }
}

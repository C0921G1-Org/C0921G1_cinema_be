package C0921G1_sprint_1.controller.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopFilm;
import C0921G1_sprint_1.dto.statistic.TopMember;
import C0921G1_sprint_1.service.statistic_management.StatisticFilmServiceImpl;
import C0921G1_sprint_1.service.statistic_management.StatisticMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/statistic")
@CrossOrigin(value = "*")
public class StatisticController {


    @Autowired
    private StatisticFilmServiceImpl statisticFilmService;
    @Autowired
    private StatisticMemberServiceImpl statisticMemberService;

    @GetMapping("/film")
    public ResponseEntity<List<TopFilm>> getAllTopFilm() {
        List<TopFilm> topFilmList = statisticFilmService.findAllTopFilm();
        if (topFilmList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(topFilmList, HttpStatus.OK);
    }

    @GetMapping("/member")
    public ResponseEntity<List<TopMember>> getAllTopMemberByQuarterAndYear(
            @RequestParam(defaultValue = "") String quarter,
            @RequestParam(defaultValue = "") String year) {
        List<TopMember> topMemberList = statisticMemberService.findAllTopMemberByQuarterAndYear(quarter, year);
        if (topMemberList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(topMemberList, HttpStatus.OK);
    }

    @GetMapping("/member/year")
    public ResponseEntity<List<String>> getYear() {
        List<String> yearList = statisticMemberService.getYear();
        if (yearList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(yearList, HttpStatus.OK);
    }
}

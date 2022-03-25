package C0921G1_sprint_1.controller.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.service.showtime_management.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ShowTimeController {
    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/showtimeList/{id}")
    public ResponseEntity<List<ShowTime>> getAllByFilmId(@PathVariable Integer id){
        List<ShowTime> showTimeList = showTimeService.getAllByFilmId(id);
        if (showTimeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(showTimeList, HttpStatus.OK);
        }
    }
}

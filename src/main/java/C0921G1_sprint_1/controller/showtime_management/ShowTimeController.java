package C0921G1_sprint_1.controller.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.service.showtime_management.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ShowTimeController {
    @Autowired
    private ShowTimeService showTimeService;

    /*DatTC - API lấy dữ liệu showTime theo filmId*/
    @GetMapping("/showtime")
    public ResponseEntity<List<ShowTime>> getAllShowTime(){
        List<ShowTime> showTimeList = this.showTimeService.getAllShowTime();
        if (showTimeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(showTimeList, HttpStatus.OK);
        }
    }

    /*DatTC - API lấy dữ liệu showTime theo filmId*/
    @GetMapping("/showtime/by-film")
    public ResponseEntity<List<ShowTime>> getAllByFilmId(@RequestParam Integer filmId, String date){
        List<ShowTime> showTimeList = this.showTimeService.getAllByFilmId(filmId, date);
        if (showTimeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(showTimeList, HttpStatus.OK);
        }
    }

    @GetMapping("/showtime/{id}")
    public ResponseEntity<ShowTime> findById(@PathVariable Integer id){
        Optional<ShowTime> showTimeOptional = this.showTimeService.findById(id);
        if (!showTimeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(showTimeOptional.get(), HttpStatus.OK);
        }
    }

}
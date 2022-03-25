package C0921G1_sprint_1.controller.seat_management;

import C0921G1_sprint_1.model.seat.Seat;
import C0921G1_sprint_1.repository.seat_management.SeatRepository;
import C0921G1_sprint_1.service.seat_management.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class SeatController {
    @Autowired
    private SeatService seatService;
    @GetMapping("/seatList")
    public ResponseEntity<Set<Seat>> getAll(){
        Set<Seat> seatSet = seatService.getAll();
        if (seatSet.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(seatSet, HttpStatus.OK);
        }
    }
}

package C0921G1_sprint_1.controller.seat_type;

import C0921G1_sprint_1.model.seat.SeatType;
import C0921G1_sprint_1.service.seat_type.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/c09/user")
public class SeatTypeController {
    @Autowired
    private SeatTypeService seatTypeService;
    @GetMapping("/seatType/{id}")
    public ResponseEntity<SeatType> findById(@PathVariable Integer id) {
        Optional<SeatType> seatTypeOptional = seatTypeService.findById(id);
        if (!seatTypeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(seatTypeOptional.get(), HttpStatus.OK);
        }
    }

}

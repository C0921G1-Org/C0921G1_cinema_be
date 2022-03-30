package C0921G1_sprint_1.controller.selected_seat_management;

import C0921G1_sprint_1.model.seat.SelectedSeat;
import C0921G1_sprint_1.service.selected_seat_management.SelectedSeatService;
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
public class SelectedSeatController {
    @Autowired
    private SelectedSeatService selectedSeatService;

    @GetMapping("/selectedSeat/{id}")
    public ResponseEntity<List<SelectedSeat>> getAllByShowTimeId(@PathVariable String id){
        List<SelectedSeat> selectedSeatList = this.selectedSeatService.getAllByShowTimeId(id);
        if (selectedSeatList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(selectedSeatList, HttpStatus.OK);
        }
    }

}
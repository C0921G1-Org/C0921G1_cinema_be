package C0921G1_sprint_1.controller;

import C0921G1_sprint_1.controller.selected_seat_management.SelectedSeatController;
import C0921G1_sprint_1.model.seat.SelectedSeat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class SelectedSeatController_getAllByShowTimeId {
    @Autowired
    private SelectedSeatController selectedSeatController;

    @Test
    public void getAllByShowTimeId_7(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId(null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getAllByShowTimeId_8(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getAllByShowTimeId_9(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("25");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getAllByShowTimeId_10(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("1");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    @Test
    public void getAllByShowTimeId_11(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("2");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
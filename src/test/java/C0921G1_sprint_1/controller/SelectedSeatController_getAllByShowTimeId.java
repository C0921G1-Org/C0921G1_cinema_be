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
    /*Lấy dữ liệu với tham số id là null*/
    @Test
    public void getAllByShowTimeId_7(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId(null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*Lấy dữ liệu với tham số id là rỗng*/
    @Test
    public void getAllByShowTimeId_8(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    /*Lấy dữ liệu với tham số id không tồn tại*/
    @Test
    public void getAllByShowTimeId_9(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("25");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*Lấy dữ liệu với tham số id tồn tại và list size = 0*/
    @Test
    public void getAllByShowTimeId_10(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("1");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*Lấy dữ liệu với tham số id tồn tại và list size > 0*/
    @Test
    public void getAllByShowTimeId_11(){
        ResponseEntity<List<SelectedSeat>> responseEntity = this.selectedSeatController.getAllByShowTimeId("2");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().get(1).getId());
        Assertions.assertEquals("3/25/2022", responseEntity.getBody().get(1).getBookingDate());
        Assertions.assertEquals(37, responseEntity.getBody().get(1).getSeatPosition());
        Assertions.assertEquals(0, responseEntity.getBody().get(1).getStatus());
        Assertions.assertEquals(1, responseEntity.getBody().get(1).getSeatType().getId());
        Assertions.assertEquals(2, responseEntity.getBody().get(1).getShowTime().getId());
    }
}
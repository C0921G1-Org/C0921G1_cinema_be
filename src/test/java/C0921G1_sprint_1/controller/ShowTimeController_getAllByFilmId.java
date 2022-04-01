//package C0921G1_sprint_1.controller;
//
//import C0921G1_sprint_1.controller.showtime_management.ShowTimeController;
//import C0921G1_sprint_1.model.showtime.ShowTime;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//@SpringBootTest
//public class ShowTimeController_getAllByFilmId {
//    @Autowired
//    private ShowTimeController showTimeController;
//
//    /*Lấy dữ liệu theo ID - TH: tham số null*/
//    @Test
//    public void getAllByFilmId_7() {
//        ResponseEntity<List<ShowTime>> responseEntity = this.showTimeController.getAllByFilmId(null);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    /*Lấy dữ liệu theo ID - TH: tham số rỗng*/
//    @Test
//    public void getAllByFilmId_8() {
//        ResponseEntity<List<ShowTime>> responseEntity = this.showTimeController.getAllByFilmId("");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//    }
//
//    /*Lấy dữ liệu theo ID - TH: tham số không tồn tại*/
//    @Test
//    public void getAllByFilmId_9() {
//        ResponseEntity<List<ShowTime>> responseEntity = this.showTimeController.getAllByFilmId("8");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    /*Lấy dữ liệu theo ID - TH: tham số tồn tại có list size < 0*/
//    @Test
//    public void getAllFilmById_10() {
//        ResponseEntity<List<ShowTime>> responseEntity = this.showTimeController.getAllByFilmId("7");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//
//    /*Lấy dữ liệu theo ID - TH: tham số tồn tại có list size > 0*/
//    @Test
//    public void getAllFilmById_11() {
//        ResponseEntity<List<ShowTime>> responseEntity = this.showTimeController.getAllByFilmId("2");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(11, responseEntity.getBody().get(3).getId());
//        Assertions.assertEquals("3/25/2022", responseEntity.getBody().get(3).getDate());
//        Assertions.assertEquals("21:00", responseEntity.getBody().get(3).getName());
//        Assertions.assertEquals(2, responseEntity.getBody().get(3).getFilm().getId());
//        Assertions.assertEquals(2, responseEntity.getBody().get(3).getScreen().getId());
//    }
//}
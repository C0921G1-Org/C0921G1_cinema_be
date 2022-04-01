//package C0921G1_sprint_1.controller;
//
//import C0921G1_sprint_1.controller.film_management.FilmController;
//import C0921G1_sprint_1.model.film.Film;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class FilmController_findAllFilmClient {
//    @Autowired
//    private FilmController filmController;
//
////    Trường hợp tất cả tham số đều null
//    @Test
//    public void findAllFilmClient_seeMore_page_startDate_name_typeFilm_7() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(null, null, null, null, null);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp tất cả đều null ngoại trừ seeMore
//    @Test
//    public void findAllFilmClient_page_startDate_name_typeFilm_7() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(0, null, null, null, null);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp tất cả đều null ngoại trừ  seeMore và page
//    @Test
//    public void findAllFilmClient_startDate_name_typeFilm_7() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0,  null, null, null);
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp name và typeFilm bị null
//    @Test
//    public void findAllFilmClient_name_typeFilm_7() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-04-01",  null, null);
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp typeFilm bị null
//    @Test
//    public void findAllFilmClient_typeFilm_7() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-04-01", "SPIDER-MAN: NO WAY HOME", null);
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp tất cả rỗng ngoại trừ seeMore và page
//    @Test
//    public void findAllFilmClient_startDate_name_typeFilm_8() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "", "", "");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp name và typeFilm bị rỗng
//    @Test
//    public void findAllFilmClient_name_typeFilm_8() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-06", "", "");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("THE BATMAN",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Robert Pattinson",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-06",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
//
////    Trường hợp typeFilm bị rỗng
//    @Test
//    public void findAllFilmClient_typeFilm_8() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-06", "THE BATMAN", "");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("THE BATMAN",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Robert Pattinson",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-06",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
////    Trường hợp cả startDate, name và typeFilm không tồn tại trong database
//    @Test
//    public void findAllFilmClient_startDate_name_typeFilm_9() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2021-10-09", "Phim Không Có", "Chưa Biết");
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    //    Trường hợp startDate  không tồn tại trong database, name rỗng và typeFilm rỗng
//    @Test
//    public void findAllFilmClient_name_typeFilm_9() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2021-10-09", "", "");
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    //    Trường hợp startDate  không tồn tại trong database, name không tồn tại trong database và typeFilm rỗng
//    @Test
//    public void findAllFilmClient_typeFilm_9() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2021-10-09", "Phim Không Có", "");
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
////    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai startDate, name, typeFilm
//    @Test
//    public void findAllFilmClient_startDate_name_typeFilm_10() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-11", "THE BATMANN", "Hành Độngg");
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    //    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai startDate
//    @Test
//    public void findAllFilmClient_name_typeFilm_10() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-11", "THE BATMAN", "Hành Động");
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    //    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai startDate và name
//    @Test
//    public void findAllFilmClient_typeFilm_10() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-11", "THE BATMANN", "Hành Động");
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    //    Trường hợp tồn tại dữ liệu trong database và nhập đúng tất cả các trường
//    @Test
//    public void findAllFilmClient_startDate_name_typeFilm_11() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-06", "THE BATMAN", "Hành Động");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("THE BATMAN",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Robert Pattinson",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-06",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
//    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng name, typeFilm và không nhập startDate
//    @Test
//    public void findAllFilmClient_name_typeFilm_11() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "", "THE BATMAN", "Hành Động");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("THE BATMAN",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Robert Pattinson",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-06",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
//
//    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng typeFilm, không nhập startDate và name
//    @Test
//    public void findAllFilmClient_typeFilm_11() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "", "", "Hành Động");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("SPIDER-MAN: NO WAY HOME",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Tom Holland",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-01",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
//    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng startDAte và name, không nhập typeFilm
//    @Test
//    public void findAllFilmClient_startDate_name_11() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-06", "THE BATMAN", "");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("THE BATMAN",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Robert Pattinson",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-06",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
//    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng startDate, không nhập typeFilm và name
//    @Test
//    public void findAllFilmClient_startDate_11() {
//        ResponseEntity<Page<Film>> responseEntity
//                = this.filmController.findAllFilmClient(6, 0, "2022-03-06", "", "");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("THE BATMAN",
//                responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("Robert Pattinson",
//                responseEntity.getBody().getContent().get(0).getActor());
//        Assertions.assertEquals("2022-03-06",
//                responseEntity.getBody().getContent().get(0).getStartDate());
//    }
//
//}

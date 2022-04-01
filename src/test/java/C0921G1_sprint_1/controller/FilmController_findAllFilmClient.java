package C0921G1_sprint_1.controller;

import C0921G1_sprint_1.controller.film_management.FilmController;
import C0921G1_sprint_1.model.film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class FilmController_findAllFilmClient {
    @Autowired
    private FilmController filmController;

//    Trường hợp tất cả tham số đều null
    @Test
    public void findAllFilmClient_seeMore_page_startDate_name_typeFilm_filmStatus_7() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(null, null, null, null, null,null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

//    Trường hợp tất cả đều null ngoại trừ seeMore
    @Test
    public void findAllFilmClient_page_startDate_name_typeFilm_filmStatus_7() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(0, null, null, null, null,null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

//    Trường hợp tất cả đều null ngoại trừ  seeMore và page
    @Test
    public void findAllFilmClient_startDate_name_typeFilm_filmStatus_7() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0,  null, null, null,null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

//    Trường hợp statusFilm, name và typeFilm bị null
    @Test
    public void findAllFilmClient_name_typeFilm_filmStatus_7() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves",  null, null,null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

//    Trường hợp typeFilm và statusFilm bị null
    @Test
    public void findAllFilmClient_typeFilm_filmStatus_7() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "THE BATMAN", null,null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp typeFilm bị null
    @Test
    public void findAllFilmClient_filmStatus_7() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "SPIDER-MAN: NO WAY HOME", "Hành Động",null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }


    //    Trường hợp tất cả rỗng ngoại trừ seeMore và page
    @Test
    public void findAllFilmClient_startDate_name_typeFilm_filmStatus_8() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "", "", "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

//    Trường hợp name , statusFilm và typeFilm bị rỗng
    @Test
    public void findAllFilmClient_name_typeFilm_filmStatus_8() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "", "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }


//    Trường hợp typeFilm và statusFilm bị rỗng
    @Test
    public void findAllFilmClient_typeFilm_filmStatus_8() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "THE BATMAN", "","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }

    //    Trường hợp statusFilm bị rỗng
    @Test
    public void findAllFilmClient_filmStatus_8() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "THE BATMAN", "Hành Động","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }

//    Trường hợp cả actor, name , statusFilm và typeFilm không tồn tại trong database
    @Test
    public void findAllFilmClient_startDate_name_typeFilm_filmStatus_9() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "jjnkk", "Phim Không Có", "Chưa Biết","phim đã chiếu");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp actor  không tồn tại trong database, name rỗng và typeFilm rỗng
    @Test
    public void findAllFilmClient_name_typeFilm_filmStatus_9() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "jkhjkhjnj", "", "","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp actor  không tồn tại trong database, name không tồn tại trong database, filmStatus và typeFilm rỗng
    @Test
    public void findAllFilmClient_typeFilm_filmStatus_9() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "hbhjbjbj", "Phim Không Có", "","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp actor  không tồn tại trong database, name không tồn tại trong database,  typeFilm không tồn tại trong database và typeFilm rỗng
    @Test
    public void findAllFilmClient_filmStatus_9() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Peyton Reed", "Phim Không Có", "sgfsgf","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

//    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai actor, name, typeFilm và statusDate
    @Test
    public void findAllFilmClient_startDate_name_typeFilm_filmStatus_10() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "sđsdf", "âsdasd", "sdvvad","12");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai actor
    @Test
    public void findAllFilmClient_name_typeFilm_filmStatus_10() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "sdsd", "THE BATMAN", "Hành Động","1");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai actor và name
    @Test
    public void findAllFilmClient_typeFilm_filmStatus_10() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "2dfdf", "ffgf", "Hành Động","1");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tồn tại dữ liệu trong database nhưng nhập sai actor , name và typeFilm
    @Test
    public void findAllFilmClient_filmStatus_10() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "2dfdf", "ffgf", "asdsad","1");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tồn tại dữ liệu trong database và nhập đúng tất cả các trường
    @Test
    public void findAllFilmClient_startDate_name_typeFilm_filmStatus_11() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "THE BATMAN", "Hành Động","1");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }

    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng name, typeFilm, statusFilm và không nhập actor
    @Test
    public void findAllFilmClient_name_typeFilm_11() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "", "THE BATMAN", "Hành Động","1");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }


    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng typeFilm và status date, không nhập actor và name
    @Test
    public void findAllFilmClient_typeFilm_11() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "", "", "Hành Động","1");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("SPIDER-MAN: NO WAY HOME",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Tom Holland",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-01",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }

    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng actor, statusFilm và name , không nhập typeFilm
    @Test
    public void findAllFilmClient_startDate_name_11() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "THE BATMAN", "","1");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }

    //    Trường hợp tồn tại dữ liệu trong database. nhập đúng actor, không nhập typeFilm , statusFilm và name
    @Test
    public void findAllFilmClient_startDate_11() {
        ResponseEntity<Page<Film>> responseEntity
                = this.filmController.findAllFilmClient(6, 0, "Matt Reeves", "", "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("THE BATMAN",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("Robert Pattinson",
                responseEntity.getBody().getContent().get(0).getActor());
        Assertions.assertEquals("2022-03-06",
                responseEntity.getBody().getContent().get(0).getStartDate());
    }
}

package C0921G1_sprint_1.film_controller;

import C0921G1_sprint_1.controller.film_management.FilmController;
import C0921G1_sprint_1.model.film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class FilmController_getListFilm {
    @Autowired
    private FilmController filmController;

    //trường hợp tham số page null
    @Test
    public void getListFilm_1_a(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(null,"","","");

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số name null
    @Test
    public void getListFilm_1_b(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,null,"","");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số startDate null
    @Test
    public void getListFilm_1_c(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"",null,"");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số endDate null
    @Test
    public void getListFilm_1_d(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","",null);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //tất cả tham số đều null
    @Test
    public void getListFilm_1_e(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(null,null,null,null);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }



    //trường hợp tham số name rỗng
    @Test
    public void getListFilm_2_a(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"",null,null);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số startDate rỗng
    @Test
    public void getListFilm_2_b(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,null,"",null);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số endStart rỗng
    @Test
    public void getListFilm_2_c(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,null,null,"");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tất cả tham số đều rỗng
    @Test
    public void getListFilm_2_d(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","","");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
    }

    //trường hợp tham số page sai
    @Test
    public void getListFilm_3_a(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(3,"","","");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số name không có trong DB
    @Test
    public void getListFilm_3_b(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"Siêu anh hùng","","");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số startDate không có trong DB
    @Test
    public void getListFilm_3_c(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","2022-05-11","");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số endDate không có trong DB
    @Test
    public void getListFilm_3_d(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","","2022-01-30");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tất cả tham số sai
    @Test
    public void getListFilm_3_e(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(45,"Siêu anh hùng","2022-04-01","2022-01-30");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số page đúng
    @Test
    public void getListFilm_4_a(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","","");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
    }

    //trường hợp tham số name đúng
    @Test
    public void getListFilm_4_b(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"Bóng Đè","","");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Bóng Đè",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-03-17",
                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-03-30",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("New Arena",
                responseEntity.getBody().getContent().get(0).getStudio());
        Assertions.assertEquals("2D",
                responseEntity.getBody().getContent().get(0).getVersion());
    }

    //trường hợp tham số startDate đúng
    @Test
    public void getListFilm_4_c(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","2022-03-27","");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Bẫy Ngọt Ngào",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-03-27",
                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-04-10",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("Vietnam",
                responseEntity.getBody().getContent().get(0).getStudio());
        Assertions.assertEquals("2D",
                responseEntity.getBody().getContent().get(0).getVersion());
    }

    //trường hợp tham số endDate đúng
    @Test
    public void getListFilm_4_d(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"","","2022-04-10");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Bẫy Ngọt Ngào",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-03-27",
                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-04-10",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("Vietnam",
                responseEntity.getBody().getContent().get(0).getStudio());
        Assertions.assertEquals("2D",
                responseEntity.getBody().getContent().get(0).getVersion());
    }

    //trường hợp các tham số đều đúng đúng
    @Test
    public void getListFilm_4_e(){
        ResponseEntity<Page<Film>> responseEntity =
                this.filmController.findAll(0,"Bóng Đè","2022-03-17","2022-03-30");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Bóng Đè",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-03-17",
                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-03-30",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("New Arena",
                responseEntity.getBody().getContent().get(0).getStudio());
        Assertions.assertEquals("2D",
                responseEntity.getBody().getContent().get(0).getVersion());
    }
}

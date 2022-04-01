package C0921G1_sprint_1.controller;

import C0921G1_sprint_1.controller.film_management.FilmController;
import C0921G1_sprint_1.model.film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class FilmController_getAllFilmList {

    @Autowired
    private FilmController filmController;

    /*Lấy dữ liệu có list size = 0*/
    @Test
    public void getAllFilmList_5() {
        ResponseEntity<List<Film>> responseEntity = this.filmController.getAllFilmList();
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*Lấy dữ liệu có list size > 0*/

    @Test
    public void getAllFilmList_6() {
        ResponseEntity<List<Film>> responseEntity = this.filmController.getAllFilmList();
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(7, responseEntity.getBody().get(6).getId());
        Assertions.assertEquals("Minh Hằng, Diệu Nhi, Bảo Anh, Thuận Nguyễn", responseEntity.getBody().get(6).getActor());
        Assertions.assertEquals("Đinh Hà Uyên Thư", responseEntity.getBody().get(6).getDirector());
        Assertions.assertEquals("90 phút", responseEntity.getBody().get(6).getDuration());
        Assertions.assertEquals("2/10/2022", responseEntity.getBody().get(6).getEndDate());
        Assertions.assertEquals(0, responseEntity.getBody().get(6).getFlagDelete());
        Assertions.assertEquals("https://www.galaxycine.vn/media/2022/2/7/bnn-800x1200_1644223760720.jpg", responseEntity.getBody().get(6).getImage());
        Assertions.assertEquals("Bẫy Ngọt Ngào", responseEntity.getBody().get(6).getName());
        Assertions.assertEquals("3/27/2022", responseEntity.getBody().get(6).getStartDate());
        Assertions.assertEquals("Vietnam", responseEntity.getBody().get(6).getStudio());
        Assertions.assertEquals("https://youtu.be/1ElIav2gMQI", responseEntity.getBody().get(6).getTrailer());
        Assertions.assertEquals("2d", responseEntity.getBody().get(6).getVersion());
        Assertions.assertEquals("5", responseEntity.getBody().get(6).getFilmType().getId());
    }
}
package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/film/")

public class FilmController {

    @Autowired
    FilmService filmService;

    //Tai DHN Xem Chi Tiết Phim
    @GetMapping("findById/{id}")
    public ResponseEntity<Film> findByIdFilm(@PathVariable Integer id){
        Optional<Film> optionalFilm =filmService.findById(id);
        if (optionalFilm.isPresent()){
            return new ResponseEntity<>(optionalFilm.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ
    @GetMapping("list-client")
    public ResponseEntity<Page<Film>> findAllFilmClient(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "") String startDate,
                                                        @RequestParam(defaultValue = "") String name,
                                                        @RequestParam(defaultValue = "") String statusFilm,
                                                        @RequestParam(defaultValue = "") String typeFilm) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<Film> filmPage = filmService.findAllFilmClient(startDate, name, statusFilm, typeFilm, pageable);
        if (filmPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(filmPage, HttpStatus.OK);
        }
    }
}

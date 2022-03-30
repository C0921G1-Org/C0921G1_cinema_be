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

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    //Tai DHN Code Chi Tiết FILM
    @GetMapping("/findById/{id}")
    private ResponseEntity<Film> findByIdFilm(@PathVariable Integer id) {
        Optional<Film> optionalFilm = filmService.finbyIdFilm(id);
        if (optionalFilm.isPresent()) {
            return new ResponseEntity<>(optionalFilm.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ
    @GetMapping("list-client")
    public ResponseEntity<Page<Film>> findAllFilmClient(@RequestParam(defaultValue = "0") int seeMore,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "") String startDate,
                                                        @RequestParam(defaultValue = "") String name,
                                                        @RequestParam(defaultValue = "") String statusFilm,
                                                        @RequestParam(defaultValue = "") String typeFilm) {

        Pageable pageable = PageRequest.of(page, seeMore);
        Page<Film> filmPage = filmService.findAllFilmClient(startDate, name, statusFilm, typeFilm, pageable);
        if (filmPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(filmPage, HttpStatus.OK);
        }
    }



    /*DatTC - API lấy dữ liệu tất cả film */
    @GetMapping("/filmList")
    public ResponseEntity<List<Film>> getAllFilmList() {
        List<Film> filmList = this.filmService.getAllFilmList();
        if (filmList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(filmList, HttpStatus.OK);
        }
    }

    /*DatTC - API lấy dữ liệu theo id */
    @GetMapping("/filmList/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable Integer id){
        Optional<Film> filmOptional = this.filmService.findById(id);
        if (!filmOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(filmOptional.get(), HttpStatus.OK);
        }
    }
}

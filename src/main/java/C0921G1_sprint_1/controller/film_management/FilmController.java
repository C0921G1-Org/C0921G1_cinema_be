package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/film/")
@CrossOrigin(origins = "*")

public class FilmController {
    @Autowired
    private FilmService filmService;

    //TaiLM danh sách phim & tìm kiếm
    @GetMapping("list-management")
    public ResponseEntity<Page<Film>> findAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "") String name,
                                              @RequestParam(defaultValue = "") String startDate,
                                              @RequestParam(defaultValue = "") String endDate) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Film> filmPage = filmService.findAll(name, startDate, endDate, pageable);
        if (filmPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(filmPage, HttpStatus.OK);
        }
    }

    //TaiLM xóa phim
    @GetMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Optional<Film> filmOptional = filmService.findById(id);
        if (filmOptional.isPresent()){
            filmService.deleteFilm(filmOptional.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Tai DHN Xem Chi Tiết Phim
    @GetMapping("findById/{id}")
    public ResponseEntity<Film> findByIdFilm(@PathVariable Integer id){
        Optional<Film> optionalFilm =filmService.findById(id);
        if (optionalFilm.isPresent()){
            return new ResponseEntity<>(optionalFilm.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

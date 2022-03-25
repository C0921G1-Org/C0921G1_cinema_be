package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/filmList")
    public ResponseEntity<List<Film>> getAllByOptions() {
        List<Film> filmList = filmService.getAll();
        if (filmList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(filmList, HttpStatus.OK);
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

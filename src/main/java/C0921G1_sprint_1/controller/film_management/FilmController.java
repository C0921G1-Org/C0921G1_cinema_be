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
@CrossOrigin("*")
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    /*DatTC - API lấy dữ liệu tất cả film */
    @GetMapping("/filmList")
    public ResponseEntity<List<Film>> getAllFilmList(){
        List<Film> filmList = this.filmService.getAllFilmList();
        if (filmList.isEmpty()){
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

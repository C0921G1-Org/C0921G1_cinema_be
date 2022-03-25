package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/filmList")
    public ResponseEntity<List<Film>> getAllByOptions() {
        List<Film> filmList= filmService.getAll();
        if (filmList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(filmList, HttpStatus.OK);
        }
    }
}

package C0921G1_sprint_1.controller.film_management;


import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;


    //Tai DHN Code Chi Tiết FILM
    @GetMapping("/findById/{id}")
    private ResponseEntity<Film> findByIdFilm(@PathVariable Integer id){
        Optional<Film> optionalFilm = filmService.finbyIdFilm(id);
        if (optionalFilm.isPresent()){
            return new ResponseEntity<>(optionalFilm.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

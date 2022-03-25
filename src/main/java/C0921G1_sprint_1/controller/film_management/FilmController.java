package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.dto.film.FilmDTO;
import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/film")
public class FilmController {
    @Autowired
    private FilmService filmService;
    // create Film of CaHm
    @PostMapping("createFilm")
    public ResponseEntity<Film>createFilm( @RequestBody FilmDTO filmDTO){
        Film film = new Film();
        BeanUtils.copyProperties(filmDTO,film);
        filmService.save(film);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}

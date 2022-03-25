package C0921G1_sprint_1.controller.film_management;
import C0921G1_sprint_1.dto.film.FilmDTO;
import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    //huynh minh ca test findAll
    @GetMapping("")
    public ResponseEntity<Iterable<Film>> findAll() {
        List<Film> filmList = (List<Film>) filmService.findAllFilm();
        return new ResponseEntity<>(filmList, HttpStatus.OK);
    }

    //Tai DHN Xem Chi Tiết Phim
    @GetMapping("findById/{id}")
    public ResponseEntity<Film> findByIdFilm(@PathVariable Integer id) {
        Optional<Film> optionalFilm = filmService.findById(id);
        if (!optionalFilm.isPresent()) {
            return new ResponseEntity<>(optionalFilm.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //huynh minh ca them moi film
    @PostMapping("/createFilm")
    public ResponseEntity<Film> createFilm(@Valid @RequestBody FilmDTO filmDTO) {
        Film film = new Film();
        BeanUtils.copyProperties(filmDTO, film);
        filmService.saveFilm(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Huynh Minh ca xem chi tiet phim theo id
    @GetMapping("/{id}/findByIdFilm")
    public ResponseEntity<Film>findByIdFilm(@PathVariable Integer id){
        Optional<Film> filmOptional = filmService.findByIdFilm(id);
        if (!filmOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(filmOptional.get(),HttpStatus.OK);

    }

    // huynh minh ca sua thong tin phim
    @PatchMapping("/{id}/editFilm")
    public ResponseEntity<Film>edit(@PathVariable Integer id, @RequestBody FilmDTO filmDTO){
//        Film film = new Film();
//        BeanUtils.copyProperties(filmDTO,film);
//        filmService.saveFilm(film);
//        return new ResponseEntity<>(HttpStatus.OK);

        Optional<Film> filmOptional = this.filmService.findById(id);
        System.out.println(filmOptional.get());
        if (!filmOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        filmDTO.setId(id);

        Film film = new Film();
        BeanUtils.copyProperties(filmDTO,film);
        this.filmService.saveFilm(film);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
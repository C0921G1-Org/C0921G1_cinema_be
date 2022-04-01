package C0921G1_sprint_1.controller.film_management;


import C0921G1_sprint_1.dto.film.FilmDTO;
import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.model.film.FilmType;
import C0921G1_sprint_1.service.film_management.FilmService;
import C0921G1_sprint_1.service.film_management.FilmTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    // Huynh Minh CA
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmTypeService filmTypeService;


    //TaiLM danh sách phim & tìm kiếm
    @GetMapping("/list-management")
    public ResponseEntity<Page<Film>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "") String name,
                                              @RequestParam(defaultValue = "") String startDate,
                                              @RequestParam(defaultValue = "") String endDate) {
        try {
            Pageable pageable = PageRequest.of(page, 10);
            Page<Film> filmPage = filmService.findAll(name, startDate, endDate, pageable);
            if (filmPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(filmPage, HttpStatus.OK);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //TaiLM xóa phim
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Film> filmOptional = filmService.findById(id);
        if (filmOptional.isPresent()) {
            filmService.deleteFilm(filmOptional.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
    @GetMapping("findById/{id}")
    public ResponseEntity<Film> findByIdFilm(@PathVariable Integer id) {
        Optional<Film> filmOptional = filmService.findByIdFilm(id);
        if (!filmOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(filmOptional.get(), HttpStatus.OK);

    }

    // huynh minh ca sua thong tin phim
    @PatchMapping("{id}")
    public ResponseEntity<Film> edit(@Valid @RequestBody FilmDTO filmDTO, @PathVariable Integer id) {

        Optional<Film> filmOptional = this.filmService.findByIdFilm(id);
        if (!filmOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmDTO.setId(filmOptional.get().getId());
        Film film = new Film();
        BeanUtils.copyProperties(filmDTO, film);
        this.filmService.updateFilm(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Huynh Minh Ca get list FilmType
    @GetMapping("/filmType")
    protected ResponseEntity<Iterable<FilmType>> findAllFilmType() {
        List<FilmType> filmTypeList = (List<FilmType>) filmTypeService.findAll();
        if (filmTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmTypeList, HttpStatus.OK);
    }


}


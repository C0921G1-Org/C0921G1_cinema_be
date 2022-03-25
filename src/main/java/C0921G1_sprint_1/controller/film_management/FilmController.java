package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.service.film_management.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/list")
    public ResponseEntity<Pageable> findAll(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 10);
        if (pageable.getPageSize()==0){
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(pageable, HttpStatus.OK);
        }
    }
}

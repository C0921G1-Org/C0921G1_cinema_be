package C0921G1_sprint_1.controller.film_management;

import C0921G1_sprint_1.model.film.FilmType;
import C0921G1_sprint_1.service.film_management.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/c09/user/film-type/")
public class FilmTypeController {
    @Autowired
    FilmTypeService filmTypeService;


    @GetMapping(value = "list")
    public ResponseEntity<List<FilmType>> getAll() {
        List<FilmType> filmTypeList;
        filmTypeList = filmTypeService.getAll();
        if (filmTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmTypeList, HttpStatus.OK);
    }

}

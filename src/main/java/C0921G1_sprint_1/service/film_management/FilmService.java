package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FilmService {
    List<Film> getAll();

}

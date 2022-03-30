package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<Film> getAllFilmList();
    Optional<Film> findById(Integer id);
}

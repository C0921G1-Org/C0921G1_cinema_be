package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;

import java.util.Optional;

public interface FilmService {
    // //Tai DHN Xem Chi Tiết Phim
    Optional<Film> findById(Integer id);
}

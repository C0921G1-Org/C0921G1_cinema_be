package C0921G1_sprint_1.service.film_management;


import C0921G1_sprint_1.model.film.Film;

import java.util.Optional;


public interface FilmService {

    void saveFilm(Film film);

    Iterable<Film> findAllFilm();


    // //Tai DHN Xem Chi Tiết Phim
    Optional<Film> findById(Integer id);

    Optional<Film> findByIdFilm(Integer id);

}

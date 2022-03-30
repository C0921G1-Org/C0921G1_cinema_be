package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.FilmType;

public interface FilmTypeService {


    // CaHM xem list FilmType
    Iterable<FilmType> findAll();
}

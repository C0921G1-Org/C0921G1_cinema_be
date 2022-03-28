package C0921G1_sprint_1.service.film_management;

<<<<<<< HEAD
import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FilmService {
    Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable);

    void deleteFilm(Integer id);

    Optional<Film> findById(Integer id);
=======
public interface FilmService {
>>>>>>> 63f908bd3561a51482101c4a356e59d35354aa6b

}

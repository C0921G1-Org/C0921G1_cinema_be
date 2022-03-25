package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FilmService {
    Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable);
}

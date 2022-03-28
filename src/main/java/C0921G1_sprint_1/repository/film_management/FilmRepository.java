package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    /*DatTC - Query lấy tất cả dữ liệu phim*/
    @Query(value="SELECT * FROM film", nativeQuery = true)
    List<Film> getAllFilmList();

}

package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    /*DatTC*/
    @Query (value = "SELECT * FROM film", nativeQuery = true)
    List<Film> getAll();
=======
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    //Tai DHN Xem Chi Tiết Phim
    @Query(value="SELECT f FROM Film  f where f.id = ?1")
    Optional<Film> findById(Integer id);
>>>>>>> 53319c79bc56c3c500040c5afbf03576751f49ce
}

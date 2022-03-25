package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query(value="select id, duration, end_date, name, start_date, studio, version\n" +
            "from film\n" +
            "where flag_delete = 1", nativeQuery = true)
    Page<Film> findAll(Pageable pageable);
}

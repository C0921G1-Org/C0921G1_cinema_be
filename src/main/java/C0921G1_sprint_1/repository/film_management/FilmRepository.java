package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query(value="select *\n" +
            "from film\n" +
            "where flag_delete = 1 and `name` like %?1% and start_date like %?2% and end_date like %?3%", nativeQuery = true)
    Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable);
}

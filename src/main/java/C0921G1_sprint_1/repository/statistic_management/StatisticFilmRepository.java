package C0921G1_sprint_1.repository.statistic_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatisticFilmRepository extends JpaRepository<Film, Integer> {
    @Query(value = "Select film.name ," +
            " COUNT(seat.transaction_id) As total_ticket," +
            " SUM(seat_type.price) AS total_money " +
            "    From Film " +
            "        left join show_time on show_time.film_id = film.id " +
            "        left join transaction on transaction.show_time_id = show_time.id " +
            "        left join seat on seat.transaction_id = transaction.id " +
            "             join seat_type on seat_type.id = seat.seat_type_id " +
            " Group by film.name " +
            " Order by total_money " +
            " Limit 10", nativeQuery = true)
    List<Film> findAllTopFilm();
}

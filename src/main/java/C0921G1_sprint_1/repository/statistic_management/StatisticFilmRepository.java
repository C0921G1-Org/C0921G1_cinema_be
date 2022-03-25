package C0921G1_sprint_1.repository.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopFilm;
import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatisticFilmRepository extends JpaRepository<Film, Integer> {
    @Query(value = " Select  film.name, " +
            " count(ticket.seat_id) As totalTicket, " +
            " SUM(seat_type.price) AS totalMoney " +
            "    From film " +
            "        left join show_time on show_time.film_id = film.id " +
            "        left join `transaction` on `transaction`.show_time_id = show_time.id " +
            "        left join ticket on `transaction`.id = ticket.transaction_id " +
            "        left join seat on seat.id = ticket.seat_id " +
            " join seat_type on seat_type.id = seat.seat_type_id " +
            " Group by film.name " +
            " Order by totalMoney " +
            " Limit 10; ", nativeQuery = true)
    List<TopFilm> findAllTopFilm();
}

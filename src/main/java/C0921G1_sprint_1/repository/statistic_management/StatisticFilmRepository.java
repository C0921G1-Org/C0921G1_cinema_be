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
            " COUNT(selected_seat.id) As totalTicket, " +
            " SUM(seat_type.price) AS totalMoney " +
            "    From Film " +
            "        left join show_time on show_time.film_id = film.id " +
            "        right join `transaction` on `transaction`.show_time_id = show_time.id " +
            "        left join selected_seat on selected_seat.show_time_id = show_time.id " +
            " left join seat_type on seat_type.id = selected_seat.seat_type_id " +
            " Group by film.name " +
            " Order by totalMoney " +
            " Limit 10; ", nativeQuery = true)
    List<TopFilm> findAllTopFilm();
}

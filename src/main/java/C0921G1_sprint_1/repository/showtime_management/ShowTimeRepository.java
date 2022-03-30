package C0921G1_sprint_1.repository.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    /*DatTC - Query lấy dữ liệu showTime theo filmId*/
    @Query(value = "SELECT * FROM show_time WHERE film_id = :filmId AND `date`= :date", nativeQuery = true)
    List<ShowTime> getAllByFilmId(@Param("filmId") Integer id, @Param("date") String date);

    /*DatTC - Query lấy tất cả dữ liệu showtime*/
    @Query(value = "SELECT * FROM show_time", nativeQuery = true)
    List<ShowTime> getAllShowTime();

    /*DatTC - Query lấy tất cả dữ liệu showtime*/
    @Query(value = "SELECT * FROM show_time WHERE id = :id", nativeQuery = true)
    Optional<ShowTime> findById(@Param("id") Integer id);
}

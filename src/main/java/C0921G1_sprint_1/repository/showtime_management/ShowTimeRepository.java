package C0921G1_sprint_1.repository.showtime_management;

import C0921G1_sprint_1.model.showtime.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    @Query (value = "SELECT * FROM show_time WHERE id LIKE :id", nativeQuery = true)
    List<ShowTime> getAllByFilmId(@Param("id") Integer id);
}

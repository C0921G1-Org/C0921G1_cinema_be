package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    //Tai DHN Xem Chi Tiết Phim
    @Query(value = "SELECT f FROM Film  f where f.id = ?1")
    Optional<Film> findById(Integer id);

    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ (phim đang chiếu)
    @Query(value = "select * from film\n" +
            "join film_type on film.film_type_id = film_type.id\n" +
            "where film.flag_delete = 1 and (?4 between film.start_date and film.end_date) and film.actor like %?1% and film.name like %?2% and film_type.name like %?3%",
            countQuery = "  select count(*) from film\n" +
                    "join film_type on film.film_type_id = film_type.id\n" +
                    "where film.flag_delete = 1 and (?4 between film.start_date and film.end_date) and film.actor like %?1% and film.name like %?2% and film_type.name like %?3%",
            nativeQuery = true)
    Page<Film> findAllFilmClientCurrent(String actor, String name, String typeFilm, String currentDate, Pageable pageable);

    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ (phim sắp chiếu)
    @Query(value = "select * from film\n" +
            "join film_type on film.film_type_id = film_type.id\n" +
            "where film.flag_delete = 1 and  start_date > ?4 and film.actor like %?1% and film.name like %?2% and film_type.name like %?3%",
            countQuery = "  select count(*) from film\n" +
                    "join film_type on film.film_type_id = film_type.id\n" +
                    "where film.flag_delete = 1 and  start_date > ?4 and film.actor like %?1% and film.name like %?2% and film_type.name like %?3%",
            nativeQuery = true)
    Page<Film> findAllFilmClientFuture(String actor, String name, String typeFilm, String currentDate, Pageable pageable);

}

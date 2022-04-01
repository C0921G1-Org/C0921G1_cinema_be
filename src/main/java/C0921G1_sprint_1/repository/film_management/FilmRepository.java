package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    /*DatTC - Query lấy tất cả dữ liệu phim*/
    @Query(value="SELECT * FROM film", nativeQuery = true)
    List<Film> getAllFilmList();

    /*DatTC - Query lấy tất cả dữ liệu phim theo id*/
    @Query(value="SELECT * FROM film WHERE id = :id", nativeQuery = true)
    List<Film> getAllFilmList(Integer id);



    //Tai DHN Xem Chi Tiết Phim
    @Query(value="SELECT f FROM Film  f where f.id = ?1")
    Optional<Film> findById(Integer id);


    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ
    @Query(value = "select * from film\n" +
            "join film_type on film.film_type_id = film_type.id\n" +
            "where film.flag_delete = \"1\" and film.start_date like %?1% and film.name like %?2% and film_type.name like %?3% and film_type.name like %?4%",
            countQuery = "  select count(*) from film\n" +
                    "join film_type on film.film_type_id = film_type.id\n" +
                    "where film.flag_delete = \"1\" and film.start_date like %?1% and film.name like %?2% and film_type.name like %?3% and film_type.name like %?4%",
            nativeQuery = true)
    Page<Film> findAllFilmClient(String startDate, String name, String statusFilm, String typeFilm, Pageable pageable);



}

package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Integer> {
    //TaiLM danh sách phim & tìm kiếm
    @Query(value="select *\n" +
            "from film\n" +
            "where flag_delete = 1 and `name` like %?1% and start_date like %?2% and end_date like %?3%", nativeQuery = true)
    Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable);

    //TaiLM xóa phim
    @Modifying
    @Query(value="update film\n" +
            "set flag_delete =0\n" +
            "where id = ?1",nativeQuery = true)
    void deleteFilm(Integer id);



    //Tai DHN Xem Chi Tiết Phim
    @Query(value="SELECT f FROM Film  f where f.id = ?1")
    Optional<Film> findById(Integer id);

}

package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    //Huỳnh Minh Ca
//    @Modifying
//    @Query(value = "insert into film (`name`,duration,start_Date,end_Date,film_Type_id,actor," +
//            " director,studio,image,trailer,version,flag_Delete) VALUES (:name,:duration,:start_Date,:end_Date," +
//            " :film_Type_id,:actor,:director,:studio,:image,:trailer,:version,:flag_Delete)", nativeQuery = true)
//    @Transactional
//    void saveFilm(@Param("name") String name,
//                  @Param("duration") String duration,
//                  @Param("start_Date") String start_Date,
//                  @Param("end_Date") String end_Date,
//                  @Param("film_Type_id") String film_Type_id,
//                  @Param("actor") String actor,
//                  @Param("director") String director,
//                  @Param("studio") String studio,
//                  @Param("image") String image,
//                  @Param("trailer") String trailer,
//                  @Param("version") String version,
//                  @Param("flag_Delete") Integer flag_Delete);
    //Tai DHN Xem Chi Tiết Phim
    @Query(value="SELECT f FROM Film  f where f.id = ?1")
    Optional<Film> findById(Integer id);
// Huynh Minh Ca xem chi tiet phim theo id

    @Query(value = "select * from film where film.id = :ids ", nativeQuery = true)
    Optional<Film> findByIdFilm(@Param("ids") Integer id);
}

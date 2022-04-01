package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film,Integer> {
  //  Huỳnh Minh Ca
    @Modifying
    @Query(value = "insert into film (`name`,duration,start_Date,end_Date,actor," +
            " director,studio,image,trailer,version,flag_Delete,film_type_new) VALUES (:name,:duration,:start_Date,:end_Date," +
            " :actor,:director,:studio,:image,:trailer,:version,:flag_Delete, :film_type_new)", nativeQuery = true)
    void saveFilm(@Param("name") String name,
                  @Param("duration") String duration,
                  @Param("start_Date") String start_Date,
                  @Param("end_Date") String end_Date,
                  @Param("actor") String actor,
                  @Param("director") String director,
                  @Param("studio") String studio,
                  @Param("image") String image,
                  @Param("trailer") String trailer,
                  @Param("version") String version,
                  @Param("flag_Delete") Integer flag_Delete,
                  @Param("film_type_new") String film_type_new);


// Huynh Minh Ca xem chi tiet phim theo id

    @Query(value = "select * from film where film.id = :ids and flag_delete =1 ", nativeQuery = true)
    Optional<Film> findByIdFilm(@Param("ids") Integer id);


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


    // CaHM update film
    @Modifying
    @Query(value = "update film set name = :name ,duration = :duration,start_Date = :start_Date,end_Date = :end_Date," +
            " actor = :actor," +
            " director = :director,studio = :studio,image = :image,trailer = :trailer,version = :version,flag_Delete= :flag_Delete," +
            " film_type_new = :film_type_new WHERE id = :id", nativeQuery = true)
    void update(
                  @Param("name") String name,
                  @Param("duration") String duration,
                  @Param("start_Date") String start_Date,
                  @Param("end_Date") String end_Date,
                  @Param("actor") String actor,
                  @Param("director") String director,
                  @Param("studio") String studio,
                  @Param("image") String image,
                  @Param("trailer") String trailer,
                  @Param("version") String version,
                  @Param("flag_Delete") Integer flag_Delete,
                  @Param("film_type_new") String film_type_new,
                  @Param("id") Integer id)
                 ;
}

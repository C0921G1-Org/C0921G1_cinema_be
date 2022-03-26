package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.FilmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Hung NM tạo để lấy list type film
@Repository
public interface FilmTypeRepository extends JpaRepository<FilmType, String> {

//    HungNM lấy danh sách thể loại phim để đổ lên màn hình tìm kiếm tại trang chủ
    @Query(value = "select * from film_type", nativeQuery = true)
    List<FilmType> getAll();
}

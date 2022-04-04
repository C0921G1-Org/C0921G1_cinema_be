package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.FilmType;

import java.util.List;

//Hung NM tạo để lấy list type film
public interface FilmTypeService {

    //HungNM lấy danh sách thể loại phim để đổ lên màn hình tìm kiếm tại trang chủ
    List<FilmType> getAll();


    // CaHM xem list FilmType
    Iterable<FilmType> findAll();

}

package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    Optional<Film> finbyIdFilm(Integer id);

    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ
    Page<Film> findAllFilmClient(String startDate, String name, String statusFilm, String typeFilm, Pageable pageable);


    List<Film> getAllFilmList();



        // Đạt làm

    Optional<Film> findById(Integer id);
}


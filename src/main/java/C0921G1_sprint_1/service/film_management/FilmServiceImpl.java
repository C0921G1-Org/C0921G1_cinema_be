package C0921G1_sprint_1.service.film_management;


import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.repository.film_management.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    //Tai DHN Xem Chi Tiết Phim
    @Override
    public Optional<Film> findById(Integer id) {
        return filmRepository.findById(id);
    }


    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ
    @Override
    public Page<Film> findAllFilmClient(String startDate, String name, String typeFilm, Pageable pageable) {
        return filmRepository.findAllFilmClient(startDate, name, typeFilm, pageable);
    }
}

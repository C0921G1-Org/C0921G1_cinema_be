package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.repository.film_management.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    //TaiLM danh sách & tìm kiếm
    @Override
    public Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable) {
        return filmRepository.findAll(name, startDate, endDate, pageable);
    }

    @Override
    public void deleteFilm(Integer id) {
        filmRepository.deleteFilm(id);
    }

    //Tai DHN Xem Chi Tiết Phim
    @Override
    public Optional<Film> findById(Integer id) {
        return filmRepository.findById(id);
    }
}

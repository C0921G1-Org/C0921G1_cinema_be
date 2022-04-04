package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.repository.film_management.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;


@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;


    @Override
    public void saveFilm(Film film) {
        film.setFlagDelete(1);
        //  film.setFilmType(new FilmType("1","Hành ĐỘng"));
        //  filmRepository.save(film);

        filmRepository.saveFilm(film.getName(), film.getDuration(), film.getStartDate(), film.getEndDate(),
                film.getActor(), film.getDirector(), film.getStudio(), film.getImage(), film.getTrailer(), film.getVersion(), film.getFlagDelete(), film.getFilmTypeNew());
    }

    // HungNM lấy danh sách phim và tìm kiếm phim ở màn hình trang chủ
    @Override
    public Page<Film> findAllFilmClient(String actor, String name, String typeFilm, String filmStatus, Pageable
            pageable) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        if ("".equals(filmStatus)) {
            return filmRepository.findAllFilmClientCurrent(actor, name, typeFilm, currentDate, pageable);
        } else if ("1".equals(filmStatus)) {
            return filmRepository.findAllFilmClientFuture(actor, name, typeFilm, currentDate, pageable);
        }
        return null;
    }


    //DatTC lấy list
    @Override
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }


    // CaHM updateFilm
    @Override
    public void updateFilm(Film film) {
        film.setFilmType(null);
        filmRepository.update(film.getName(), film.getDuration(), film.getStartDate(), film.getEndDate(),
                film.getActor(), film.getDirector(), film.getStudio(), film.getImage(), film.getTrailer(), film.getVersion(), film.getFlagDelete(), film.getFilmTypeNew(), film.getId());
    }

    //TaiLM danh sách & tìm kiếm phím quản lí
    @Override
    public Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable) {
        return filmRepository.findAll(name, startDate, endDate, pageable);
    }

    //TaiLM delete film
    @Override
    public void deleteFilm(Integer id) {
        filmRepository.deleteFilm(id);
    }

    // TaiLM tim film theo id
    @Override
    public Optional<Film> findByIdFilm(Integer id) {
        return filmRepository.findByIdFilm(id);
    }

}

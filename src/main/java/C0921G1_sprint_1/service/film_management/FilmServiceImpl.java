package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;

import C0921G1_sprint_1.model.film.FilmType;
import C0921G1_sprint_1.repository.film_management.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;


import java.util.List;


@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;


    // huynh minh ca save film
    @Override
    public void saveFilm(Film film) {
        film.setFlagDelete(1);
    //   film.setFilmType(new FilmType());
     //  filmRepository.save(film);
       filmRepository.saveFilm(film.getName(), film.getDuration(),film.getStartDate(),film.getEndDate(),film.getFilmType().getId(),
              film.getActor(),film.getDirector(), film.getStudio(),film.getImage(),film.getTrailer(),film.getVersion(),film.getFlagDelete());
    }
    // CaHM updateFilm
    @Override
    public void updateFilm(Film film) {
        filmRepository.save(film);
    }

    //TaiLM danh sách & tìm kiếm
    @Override
    public Page<Film> findAll(String name, String startDate, String endDate, Pageable pageable){
        return filmRepository.findAll(name,  startDate, endDate, pageable);
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

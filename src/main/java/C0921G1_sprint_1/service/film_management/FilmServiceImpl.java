package C0921G1_sprint_1.service.film_management;


import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.repository.film_management.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service

public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;
    @Override
    public void saveFilm(Film film) {
        filmRepository.save(film);
//        filmRepository.saveFilm(film.getName(), film.getDuration(),film.getStartDate(),film.getEndDate(),film.getFilmType().getId(),
//                film.getStudio(),film.getActor(),film.getDirector(),film.getImage(),film.getTrailer(),film.getVersion(),film.getFlagDelete());
    }

    @Override
    public Iterable<Film> findAllFilm() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<Film> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Film> findByIdFilm(Integer id) {
        return filmRepository.findByIdFilm(id);
    }

    //Tai DHN Xem Chi Tiết Phim


}

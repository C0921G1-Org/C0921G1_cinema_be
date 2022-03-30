package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.repository.film_management.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAllFilmList() {
        return filmRepository.getAllFilmList();
    }

    @Override
    public Optional<Film> findById(Integer id) {
        return filmRepository.findById(id);
    }
}

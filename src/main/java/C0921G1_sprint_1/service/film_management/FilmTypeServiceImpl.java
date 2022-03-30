package C0921G1_sprint_1.service.film_management;

import C0921G1_sprint_1.model.film.FilmType;
import C0921G1_sprint_1.repository.film_management.FilmTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmTypeServiceImpl implements FilmTypeService{
    //huynh Minh Ca
    @Autowired
    private FilmTypeRepository filmTypeRepository;

    @Override
    public Iterable<FilmType> findAll() {
        return filmTypeRepository.findAll();
    }
}

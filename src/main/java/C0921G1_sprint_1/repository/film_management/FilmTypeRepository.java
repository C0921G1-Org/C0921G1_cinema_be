package C0921G1_sprint_1.repository.film_management;

import C0921G1_sprint_1.model.film.FilmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmTypeRepository extends JpaRepository<FilmType,Long> {
}

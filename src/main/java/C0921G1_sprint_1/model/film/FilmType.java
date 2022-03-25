package C0921G1_sprint_1.model.film;

import C0921G1_sprint_1.custom_id.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class FilmType {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "filmType")
    @JsonBackReference
    private Set<Film> films;

    public FilmType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}

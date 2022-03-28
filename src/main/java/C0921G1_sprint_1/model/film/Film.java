package C0921G1_sprint_1.model.film;

import C0921G1_sprint_1.model.showtime.ShowTime;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String duration;
    private String startDate;
    private String endDate;

    @ManyToOne(targetEntity = FilmType.class)
    private FilmType filmType;

    @OneToMany(mappedBy = "film")
    @JsonBackReference(value = "showTimes_film")
    private Set<ShowTime> showTimes;

    private String actor;
    private String director;
    private String studio;

    private String image;

    private String trailer;

    private String version;
    private Integer flagDelete;

    public Film() {
    }

    public Film(Integer id, String name, String duration, String startDate, String endDate, FilmType filmType, Set<ShowTime> showTimes, String actor, String director, String studio, String image, String trailer, String version, Integer flagDelete) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.filmType = filmType;
        this.showTimes = showTimes;
        this.actor = actor;
        this.director = director;
        this.studio = studio;
        this.image = image;
        this.trailer = trailer;
        this.version = version;
        this.flagDelete = flagDelete;
    }

    public Set<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(Set<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

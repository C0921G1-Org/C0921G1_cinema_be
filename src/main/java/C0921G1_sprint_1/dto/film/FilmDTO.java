package C0921G1_sprint_1.dto.film;

import C0921G1_sprint_1.model.film.FilmType;
import C0921G1_sprint_1.model.showtime.ShowTime;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class FilmDTO implements Validator {
    private Integer id;
  //  @NotBlank()
  //  @Pattern(message = "The movie title must be correct for example: Cu Dam Mau,...",regexp = "^([A-Z][a-z]+)( [A-Z][a-z]*)*$")
    private String name;
  //  @NotBlank()
    private String duration;
    private String startDate;
  //  @NotBlank
    private String endDate;
    private FilmType filmType;
  //  @NotBlank()
  //  @Pattern(message ="name actor must be correct for example: Nguyen Van A,..." ,regexp ="^([A-Z][a-z]+)( [A-Z][a-z]*)*$" )
    private String actor;
 //   @NotBlank()
    private String director;
  //  @NotBlank()
    private String studio;
  //  @NotBlank()
    private String image;
  //  @NotBlank()
    private String trailer;
  //  @NotBlank()
    private String version;

    private Integer flagDelete;

    public FilmDTO() {
    }


    public FilmDTO(Integer id, String name, String duration, String startDate, String endDate, FilmType filmType, Set<ShowTime> showTimes, String actor, String director, String studio, String image, String trailer, String version, Integer flagDelete) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.filmType = filmType;
        this.actor = actor;
        this.director = director;
        this.studio = studio;
        this.image = image;
        this.trailer = trailer;
        this.version = version;
        this.flagDelete = flagDelete;
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

    public Integer getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

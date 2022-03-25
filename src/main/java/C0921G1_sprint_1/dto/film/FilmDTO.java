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
    private Set<ShowTime> showTimes;
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

    public FilmDTO() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

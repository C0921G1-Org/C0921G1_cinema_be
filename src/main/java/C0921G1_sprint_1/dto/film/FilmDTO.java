package C0921G1_sprint_1.dto.film;

import C0921G1_sprint_1.model.film.FilmType;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;


public class FilmDTO implements Validator {
    private Integer id;
    @NotBlank(message = "This field cannot be left blank")
    private String name;
    @Pattern(message = "Input unit is number",regexp = "\\d*")
    @Min(message = "min duration = 10",value = 10)
    @Max(message = "max duration = 240",value = 240)
    @NotBlank(message = "This field cannot be left blank")
    private String duration;

    @NotBlank(message = "This field cannot be left blank")
    private String startDate;
    @NotBlank(message = "This field cannot be left blank")
    private String endDate;
//    @NotBlank(message = "This field cannot be left blank")
//    private String typeFilmNew;
    private FilmType filmType;
    @NotBlank(message = "This field cannot be left blank")
 //   @Pattern(message ="name actor must be correct for example: Nguyen Van A,..." ,regexp ="^([A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+)( [A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]*)*$" )
    private String actor;
    @NotBlank(message = "This field cannot be left blank")
    @Pattern(message ="name actor must be correct for example: Nguyen Van A,..." ,regexp ="^([A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+)( [A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]*)*$" )
    private String director;
    @NotBlank(message = "This field cannot be left blank")
    private String studio;
    @NotBlank(message = "This field cannot be left blank")
    private String image;
    @NotBlank(message = "This field cannot be left blank")
    private String trailer;
    @NotBlank(message = "This field cannot be left blank")
    private String version;

    private Integer flagDelete;
    //CaHM fix CheckBox
    @NotBlank(message = "This field cannot be left blank")
    private String filmTypeNew;

    public FilmDTO() {
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

    public String getFilmTypeNew() {
        return filmTypeNew;
    }

    public void setFilmTypeNew(String filmTypeNew) {
        this.filmTypeNew = filmTypeNew;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    FilmDTO filmDTO = (FilmDTO) target;
    String startDate = filmDTO.startDate;
    String endDate = filmDTO.endDate;
    if(ValidateStartAndEndDate.checkNgay(startDate,endDate)){
        errors.rejectValue("startDate","startDate.CheckDate");
    }
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}

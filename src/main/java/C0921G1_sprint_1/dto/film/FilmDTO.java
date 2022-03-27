package C0921G1_sprint_1.dto.film;

import C0921G1_sprint_1.model.film.FilmType;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FilmDTO implements Validator {
    private Integer id;
    @NotBlank(message = "This field cannot be left blank")
    private String name;
    @NotBlank(message = "This field cannot be left blank")
    private String duration;
    @NotBlank(message = "This field cannot be left blank")
    private String startDate;
    @NotBlank(message = "This field cannot be left blank")
    private String endDate;
    private FilmType filmType;
    @NotBlank(message = "This field cannot be left blank")
    private String actor;
    @NotBlank(message = "This field cannot be left blank")
    @Pattern(message ="name actor must be correct for example: Nguyen Van A,..." ,regexp ="^([A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+)( [A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]*)*$" )
    private String director;
    @NotBlank(message = "This field cannot be left blank")
    @Pattern(message ="name actor must be correct for example: Studio Victory,..." ,regexp ="^([A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+)( [A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]*)*$" )
    private String studio;
    @NotBlank(message = "This field cannot be left blank")
    private String image;
    @NotBlank(message = "This field cannot be left blank")
    private String trailer;
    @NotBlank(message = "This field cannot be left blank")
    private String version;

    private Integer flagDelete;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
    public static Boolean checkNgay(String startDate, String endDate) {
        boolean flag;
        Date ngayChieu = null;
        Date ngayKetThuc = null;

        try {
            ngayChieu = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            ngayKetThuc = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        } catch (ParseException e) {
            flag = false;
        }
        if (ngayChieu.compareTo(ngayKetThuc) > 0) {
            flag = false;
        } else if (ngayChieu.compareTo(ngayKetThuc) < 0) {
            flag = true;
        } else {
            flag = true;
        }
        return flag;
    }


}

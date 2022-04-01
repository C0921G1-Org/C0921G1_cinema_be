package C0921G1_sprint_1.dto.member;

import C0921G1_sprint_1.model.member.City;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import C0921G1_sprint_1.model.member.Ward;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;

public class MemberDTO implements Validator {
    private String id;

    @NotBlank
//    @Pattern(regexp = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$",
//            message = "Tên cần viết Hoa Chữ cái đầu")
    private String name;
    @NotNull
    private Integer gender;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotNull
    private Double point;
    @NotBlank
    private String image;

    @NotBlank
//    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])")
    private String dateOfBirth;
    @NotBlank
    private String identityNumber;

    //    private Ward ward;
    private City city;

    public MemberDTO() {
    }


//    public Ward getWard() {
//        return ward;
//    }
//
//    public void setWard(Ward ward) {
//        this.ward = ward;
//    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;

        if (checkAgeMember(memberDTO.getDateOfBirth())) {
            errors.rejectValue("dateOfBirth", "birthday.checkAge", "Tuổi phải từ 16 đến 100");
        }
        if (checkName(memberDTO.getName())) {
            errors.rejectValue("name", "name.checkName", "Tên cần viết Hoa Chữ cái đầu");
        }


    }

    //check age name regex - NhanNT
    public boolean checkName(String name) {
        Pattern pattern = Pattern.compile("^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    //check age member >= 16 - NhanNT
    public boolean checkAgeMember(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        Pattern pattern = Pattern.compile("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])");
        Matcher matcher = pattern.matcher(dateOfBirth);

        boolean isRetry = false;

        if (!matcher.matches()) {
            isRetry = true;
        } else {
            LocalDate birthDay = LocalDate.parse(dateOfBirth, formatter);
            LocalDate after16Years = birthDay.plusYears(16);
            LocalDate before100Years = birthDay.plusYears(100);
            if (after16Years.isAfter(now) || before100Years.isBefore(now)) {
                isRetry = true;
            }
        }


        return isRetry;

    }
}

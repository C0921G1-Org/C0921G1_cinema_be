package C0921G1_sprint_1.dto.member;

import C0921G1_sprint_1.model.member.City;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import C0921G1_sprint_1.model.member.Ward;
import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

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
    private String name;

    @NotNull
    private Integer gender;

    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    private Double point;


    private String image;


    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String identityNumber;

    @NotBlank
    private String password;

//    private Integer wardId;
//    @NotBlank
    private Integer cityId;


//    private Account account;

    //    private Ward ward;
    private City city;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Integer getWardId() {
//        return wardId;
//    }
//
//    public void setWardId(Integer wardId) {
//        this.wardId = wardId;
//    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public MemberDTO() {
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;

//        if (!memberDTO.name.matches("^[\\p{Lu}\\p{Ll}\\s0-9]+$") || memberDTO.name.length() > 50 || memberDTO.name.length() < 1) {
//            errors.rejectValue("name",
//                    "name.wrongName",
//                    "Tên không được phép có số hoặc ký tự đặc biệt. Tối thiểu 1 ký tự và tối đa 50 ký tự");
//        }


        if (memberDTO.gender == null || memberDTO.gender < 0 || memberDTO.gender > 1) {
            errors.rejectValue("gender", "gender.wrongGender", "Vui lòng chọn giới tính phù hợp");
        }



        if (!memberDTO.email.matches("^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$")) {
            errors.rejectValue("email", "email.wrongMail", "sai format Email.");
        }

        if (memberDTO.email.length() < 10 || memberDTO.email.length() > 40) {
            errors.rejectValue("email", "email.wrongLengthMail", "Email có độ dài tối thiểu là 10 đến 40 ký tự.");
        }

        if (!memberDTO.identityNumber.matches("^\\d{9,10}$")) {
            errors.rejectValue("identityNumber", "identityNumber.wrongIdentityCard", "CMND phải có 9 hoặc 10 số");
        }

//        if (memberDTO.cityId == null) {
//            errors.rejectValue("cityId", "cityId.nullCityId", "Bắt buộc thành viên phải có địa chỉ");
//        }
//        if (memberDTO.wardId == null) {
//            errors.rejectValue("wardId", "wardId.nullWardId", "Bắt buộc thành viên phải có địa chỉ");
//        }
        if (checkAgeMember(memberDTO.getDateOfBirth())) {
            errors.rejectValue("dateOfBirth", "birthday.checkAge", "Tuổi phải từ 16 trở lên");
        }
        if (checkName(memberDTO.getName())) {
            errors.rejectValue("name", "name.checkName", "Tên cần viết Hoa Chữ cái đầu");
        }
        if (checkPhone(memberDTO.getPhone())) {
            errors.rejectValue("phone", "phone.checkPhone", "Số điện thoại phải có 10 số và có số 0 phía trước");
        }

    }

    //check phone regex - NhanNT
    public boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("\\(?(0[1-9]{2})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            return true;
        } else {
            return false;
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


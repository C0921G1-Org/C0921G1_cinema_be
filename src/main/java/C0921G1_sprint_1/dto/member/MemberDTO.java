package C0921G1_sprint_1.dto.member;

import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class MemberDTO implements Validator {

    private String id;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Pattern(regexp = RegexMember.REGEX_MEMBER_NAME,
            message = "Dữ liệu không hợp lệ! Tên không bao gồm số hoặc kí tự đặc biệt!")
    @Size(min = 8, message = "Dữ liệu không hợp lệ! Tên ít nhất bao gồm 8 kí tự!")
    private String name;

    private Integer gender;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Pattern(regexp = RegexMember.REGEX_PHONE_NUMBER,
            message = "Dữ liệu không hợp lệ! Số điện thoại phải tuân theo chuẩn của Việt Nam!")
    private String phone;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Email(message = "Dữ liệu không hợp lệ! Email phải tuân theo chuẩn quy ước!")
    private String email;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    private String address;

    private Double point;

//    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    private String image;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    private String dateOfBirth;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Pattern(regexp = RegexMember.REGEX_IDENTITY_NUMBER,
            message = "Dữ liệu không hợp lệ! Số chứng minh nhân dân phải tuân theo chuẩn quy ước!")
    private String identityNumber;

    private City city;

    private Set<Transaction> transactions;

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

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;

        String dateOfBirth = memberDTO.dateOfBirth;
//        System.out.println(RegexMember.checkAgeMember(dateOfBirth));
        if (RegexMember.checkAgeMember(dateOfBirth)) {
            errors.rejectValue("dateOfBirth","dateOfBirth.age");
        }

    }


    //need solution to solve a problem - how can validate vietnamese name - KhanhLDQ

}

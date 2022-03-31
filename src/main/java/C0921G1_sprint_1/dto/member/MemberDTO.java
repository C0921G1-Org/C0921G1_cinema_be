package C0921G1_sprint_1.dto.member;

import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class MemberDTO implements Validator {
    @NotNull
    private String id;

    @NotNull
    private Account account;

    private String name;
    private Integer gender;
    private String phone;
    private String email;
    private String address;
    private Double point;
    private String image;
    private String dateOfBirth;
    private String identityNumber;
    private City city;
    private Set<Transaction> transactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", image='" + image + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", city=" + city +
                ", transactions=" + transactions +
                '}';
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;


        if (!memberDTO.name.matches("^[\\p{Lu}\\p{Ll}\\s0-9]+$") || memberDTO.name.length() > 50) {
            errors.rejectValue("name",
                    "name.wrongName",
                    "Tên không được phép có số hoặc ký tự đặc biệt. Tối thiểu 1 ký tự và tối đa 50 ký tự");
        }

        if (memberDTO.account == null) {
            errors.rejectValue("account", "account.nullAccount", "Bắt buộc thành viên phải có tài khoản");
        }

        if (memberDTO.gender == null || memberDTO.gender <0 || memberDTO.gender > 1) {
            errors.rejectValue("gender", "gender.wrongGender", "Vui lòng chọn giới tính phù hợp");
        }

        if (!(memberDTO.phone.matches("^(84+|0)(90|91)[0-9]{7}$"))) {
            errors.rejectValue("phone", "phone.wrongPhone",
                    "Số điện thoại phải theo định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84) 90xxxxxxx hoặc (84) 91xxxxxxx");
        }

        if (!memberDTO.email.matches("^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$")) {
            errors.rejectValue("email", "email.wrongMail", "sai format Email.");
        }

        if (memberDTO.email.length() <10 || memberDTO.email.length() > 40 ) {
            errors.rejectValue("email", "email.wrongLengthMail", "Email có độ dài tối thiểu là 10 đến 40 ký tự.");
        }

        if (!memberDTO.identityNumber.matches("^\\d{9,10}$")) {
            errors.rejectValue("identityNumber", "identityNumber.wrongIdentityCard", "CMND phải có 9 hoặc 10 số");
        }

        if (memberDTO.city == null) {
            errors.rejectValue("city", "city.nullCity", "Bắt buộc thành viên phải có thành phố");
        }


    }
}

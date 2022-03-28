package C0921G1_sprint_1.dto.member;

import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.model.transaction.Transaction;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class MemberDTO {
    @NotNull
    private String id;
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
}

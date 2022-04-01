package C0921G1_sprint_1.model.member;

import C0921G1_sprint_1.custom_id.StringPrefixedSequenceIdGenerator;
import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @GenericGenerator(
            name = "member_seq",
            strategy = "C0921G1_sprint_1.custom_id.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Mem-"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
    private String id;


    private String name;
    private Integer gender;
    private String phone;
    private String email;
    private String address;
    private Double point;
    private String image;
    private String dateOfBirth;
    private String identityNumber;

    @ManyToOne(targetEntity = Ward.class)
    private Ward ward;

    @OneToMany(mappedBy = "member")

    @JsonBackReference("member_transaction")
    private Set<Transaction> transactions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
//    @NotNull
    private Account account;

    public Member() {
    }

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

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }


    public Set<Transaction> getTransactions() {
        return transactions;
    }


    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;

    }
}

//    public Ward getWard() {
//        return ward;
//    }
//
//    public void setWard(Ward ward) {
//        this.ward = ward;
//    }


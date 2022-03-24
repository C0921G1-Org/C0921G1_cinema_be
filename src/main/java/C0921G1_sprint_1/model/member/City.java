package C0921G1_sprint_1.model.member;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //có nhiều @JsonBackReference thì tạo thêm value để phân biệt
    @OneToMany(mappedBy = "city")
    @JsonBackReference(value = "city_district")
    private Set<District> districts;

    @OneToMany(mappedBy = "city")
    @JsonBackReference(value = "city_member")
    private Set<Member> members;

    public City() {
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

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}

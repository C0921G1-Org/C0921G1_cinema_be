package C0921G1_sprint_1.repository.member_management;

import C0921G1_sprint_1.model.member.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {
    @Query(value = "Select d.id,d.name,d.type,d.city_id \n" +
            "from district d\n" +
            "where d.city_id = ?1",nativeQuery = true)
    List<District>findDistinctByCity_Id(int id);
}

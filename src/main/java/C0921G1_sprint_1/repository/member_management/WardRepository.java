package C0921G1_sprint_1.repository.member_management;



import C0921G1_sprint_1.model.member.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward,Integer> {

    @Query(value = "Select w.id,w.`name`,w.`type`,w.district_id \n" +
            "from ward w\n" +
            "where w.district_id = ?1",nativeQuery = true)
    List<Ward> findWardByDistrict_Id(int id);

}

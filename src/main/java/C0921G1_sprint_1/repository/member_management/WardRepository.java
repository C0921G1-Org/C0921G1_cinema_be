package C0921G1_sprint_1.repository.member_management;

import C0921G1_sprint_1.model.member.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<Ward,Integer> {
}
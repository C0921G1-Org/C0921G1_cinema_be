package C0921G1_sprint_1.repository.statistic_management;

import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticMemberRepository extends JpaRepository<Member,String> {
}

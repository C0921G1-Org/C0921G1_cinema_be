package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.model.member.Member;

import java.util.List;

public interface StatisticMemberService {
    List<Member> findAllTopMember();
}

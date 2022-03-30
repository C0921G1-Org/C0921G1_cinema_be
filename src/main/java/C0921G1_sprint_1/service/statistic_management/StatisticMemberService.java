package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopMember;

import java.util.List;

public interface StatisticMemberService {
    List<TopMember> findAllTopMemberByQuarterAndYear(String quarter, String year);
    List<String> getYear();
}

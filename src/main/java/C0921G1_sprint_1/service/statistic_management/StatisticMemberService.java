package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopMember;

import java.util.List;

public interface StatisticMemberService {
    List<TopMember> findAllTopMemberByYear(String year);
    List<TopMember> findAllTopMemberByQuarterAndYear(String monthStart, String monthEnd, String year);
}

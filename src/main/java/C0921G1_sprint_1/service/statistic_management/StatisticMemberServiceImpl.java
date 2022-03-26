package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopMember;
import C0921G1_sprint_1.repository.statistic_management.StatisticMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticMemberServiceImpl implements StatisticMemberService {
    @Autowired
    StatisticMemberRepository repository;

    @Override
    public List<TopMember> findAllTopMemberByYear(String year) {
        return repository.findAllTopMemberByYear(year);
    }

    @Override
    public List<TopMember> findAllTopMemberByQuarterAndYear(String monthStart, String monthEnd, String year) {
        return repository.findAllTopMemberByQuarterAndYear(monthStart,monthEnd,year);
    }
}

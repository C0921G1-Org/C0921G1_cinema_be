package C0921G1_sprint_1.service.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopMember;
import C0921G1_sprint_1.repository.statistic_management.StatisticMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticMemberServiceImpl implements StatisticMemberService {
    @Autowired
    StatisticMemberRepository repository;

    @Override
    public List<TopMember> findAllTopMemberByQuarterAndYear(String quarter, String year) {
        List<TopMember> topMemberList = new ArrayList<>();
        if (quarter == null) {
            return topMemberList;
        } else if (year == null) {
            return topMemberList;
        }
        if ("".equals(year)&& !quarter.equals("")) {
            return topMemberList;
        }
        if ("".equals(quarter)) {
            if("".equals(year)){
                topMemberList = repository.findAllTopMemberByYear("");
            }else {
                topMemberList = repository.findAllTopMemberByYear(year);
            }
        } else if (quarter.equals("1")) {
            topMemberList = repository.findAllTopMemberByQuarterAndYear("1", "3", year);
        } else if (quarter.equals("2")) {
            topMemberList = repository.findAllTopMemberByQuarterAndYear("3", "6", year);
        } else if (quarter.equals("3")) {
            topMemberList = repository.findAllTopMemberByQuarterAndYear("6", "9", year);
        } else if (quarter.equals("4")) {
            topMemberList = repository.findAllTopMemberByQuarterAndYear("9", "12", year);
        } else return topMemberList;
        return topMemberList;
    }

    @Override
    public List<String> getYear() {
        return repository.getYear();
    }
}

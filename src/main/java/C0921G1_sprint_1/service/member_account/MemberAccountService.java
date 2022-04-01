package C0921G1_sprint_1.service.member_account;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.District;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.member.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberAccountService {


    //    NhanNT get Trading History
    public Page<MemberHistoryDTO> findTradingHistory(String id,String name, Pageable pageable);
    //    NhanNT Create Member
    public void createMember(MemberDTO member);
    //    NhanNT get City
    public Iterable<City> getListCity();
    //    NhanNT get District
    public Iterable<District> getListDistrict(int id);
    //    NhanNT get ward
    public Iterable<Ward> getListWard(int id);



}

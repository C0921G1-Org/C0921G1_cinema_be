package C0921G1_sprint_1.service.member_account;

import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberAccountService {


    //    NhanNT get Trading History
    Page<MemberHistoryDTO> findTradingHistory(String id, Pageable pageable);
    //    NhanNT Create Member
    void createMember(Member member);



}

package C0921G1_sprint_1.service.member_account;

import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberAccountService {


    Page<MemberHistoryDTO> findTradingHistory(int id, Pageable pageable);
}

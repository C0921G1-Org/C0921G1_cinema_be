package C0921G1_sprint_1.service.member_account;

import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.repository.member_account.MemberAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class MemberAccountServiceImpl implements MemberAccountService{

    @Autowired
    MemberAccountRepository memberAccountRepository;

    @Override
    public Page<MemberHistoryDTO> findTradingHistory(int id, Pageable pageable) {
        return memberAccountRepository.findTradingHistory(id,pageable);
    }
}

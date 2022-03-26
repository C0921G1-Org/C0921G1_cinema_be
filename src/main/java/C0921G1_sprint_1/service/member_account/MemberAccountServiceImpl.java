package C0921G1_sprint_1.service.member_account;

import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.repository.member_account.MemberAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountServiceImpl implements MemberAccountService{

    @Autowired
    private MemberAccountRepository memberAccountRepository;


    //    NhanNT get Trading history
    @Override
    public Page<MemberHistoryDTO> findTradingHistory(String id,String name, Pageable pageable) {
        return memberAccountRepository.findTradingHistory(id,name,pageable);
    }


    //    NhanNT create Member
    @Override
    public void createMember(Member member) {
        memberAccountRepository.save(member);
    }
}

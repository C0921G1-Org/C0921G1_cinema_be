package C0921G1_sprint_1.service.member_management;


import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.repository.member_management.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

}

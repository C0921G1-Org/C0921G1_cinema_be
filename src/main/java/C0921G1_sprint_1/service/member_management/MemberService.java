package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(String id);

    void save(Member member);

}

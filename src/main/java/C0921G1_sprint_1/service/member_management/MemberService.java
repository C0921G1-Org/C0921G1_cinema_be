package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberService {

    Iterable<Member> findAllMembers();

    Page<Member> findAllMembersWithPagination(Pageable pageable);

    Optional<Member> findMemberById(String id);

    void saveMember(Member member);

    Page<Member> findMembersByName(Pageable pageable, String name);

    Page<Member> findMembersByCity(Pageable pageable, Integer cityId);

    Page<Member> findMembersByPointRange(Pageable pageable, Integer firstValue, Integer secondValue);
}

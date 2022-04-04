package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.member.Ward;
import C0921G1_sprint_1.model.security.Account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberService {

    Optional<Member> findById(String id);

    Iterable<Member> findAllMembers();

    Page<Member> findAllMembersWithPagination(Pageable pageable);

    Optional<Member> findMemberById(String id);


    void saveMember(Member member);

    void save(Member member);

    Optional<Member> findMemberByAccount(Integer accountId);



}

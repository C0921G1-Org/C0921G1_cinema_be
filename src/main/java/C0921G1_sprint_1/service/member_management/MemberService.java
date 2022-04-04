package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.security.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberService {

    Iterable<Member> findAllMembers();

    Iterable<City> findAllCities();




    Optional<Member> findById(String id);



    Page<Member> findAllMembersWithPagination(Pageable pageable);

    Optional<Member> findMemberById(String id);

    void saveMember(Member member);

    Page<Member> findMembersByNameAndPointRange(
            Pageable pageable, String name, Integer firstValue, Integer secondValue);

    Page<Member> findMembersByNameAndPointDefault(Pageable pageable, String name);


    void save(Member member);

    Optional<Member> findMemberByAccount(Account accpunt);



    Optional<Member> existedMemberByEmail(String email);
}

package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.repository.member_management.CityRepository;
import C0921G1_sprint_1.repository.member_management.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<Member> findAllMembers() {
        return this.memberRepository.findAllMembers();
    }

    @Override
    public Iterable<City> findAllCities() {
        return this.cityRepository.findAllCities();
    }

    @Override
    public Page<Member> findAllMembersWithPagination(Pageable pageable) {
        return this.memberRepository.findAllMembersWithPagination(pageable);
    }

    @Override
    public Optional<Member> findMemberById(String id) {
        return this.memberRepository.findMemberById(id);
    }

    @Override
    public void saveMember(Member member) {
        this.memberRepository.updateMember(member.getName(),member.getGender(),member.getPhone(),member.getEmail(),
                member.getAddress(),member.getImage(),member.getDateOfBirth(),member.getIdentityNumber(),member.getCity().getId(),member.getId());
    }

    @Override
    public Page<Member> findMembersByNameAndPointRange(Pageable pageable, String name, Integer firstValue, Integer secondValue) {
        return this.memberRepository.findMembersByNameAndPointRange(pageable, name, firstValue, secondValue);
    }

    @Override
    public Page<Member> findMembersByNameAndPointDefault(Pageable pageable, String name) {
        return this.memberRepository.findMembersByNameAndPointDefault(pageable, name);
    }

    @Override
    public Optional<Member> existedMemberByEmail(String email) {
        return this.memberRepository.existedMemberByEmail(email);
    }

}

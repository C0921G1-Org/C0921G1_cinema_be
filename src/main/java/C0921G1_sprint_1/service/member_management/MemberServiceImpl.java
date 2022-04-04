package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.repository.member_management.CityRepository;


import C0921G1_sprint_1.model.member.Ward;

import C0921G1_sprint_1.model.security.Account;

import C0921G1_sprint_1.repository.member_management.MemberRepository;
import C0921G1_sprint_1.repository.member_management.WardRepository;
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

    @Autowired
    private WardRepository wardRepository;

    @Override
    public Optional<Member> findById(String id) {
        if (id == null || id.equals("")) {
            return Optional.empty();
        }
        return memberRepository.findById(id);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
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
    public Optional<Member> findMemberByAccount(Integer accountId) {
        return this.memberRepository.findMemberByAccount(accountId);
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


package C0921G1_sprint_1.service.member_management;

import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.member.Ward;
import C0921G1_sprint_1.repository.member_management.MemberRepository;
import C0921G1_sprint_1.repository.member_management.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.repository.member_management.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

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
    public Iterable<Member> findAllMembers() {
        return this.memberRepository.findAllMembers();
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

    }

//<<<<<<< HEAD
//    @Override
//    public void saveMember(Member member) {
//        this.memberRepository.updateMember(member.getName(),member.getGender(),member.getPhone(),member.getEmail(),
//                member.getAddress(),member.getImage(),member.getDateOfBirth(),member.getIdentityNumber(),member.getWard().getId(),member.getId());
//    }
//=======
//>>>>>>> a22d5e9ca102626a39c74a2a833ae6e1574d7a87


//
//    @Override
//    public void saveMember(Member member) {
//        this.memberRepository.updateMember(member.getName(),member.getGender(),member.getPhone(),member.getEmail(),
//                member.getAddress(),member.getImage(),member.getDateOfBirth(),member.getIdentityNumber(),member.getWard().getId(),member.getId());
//    }


}


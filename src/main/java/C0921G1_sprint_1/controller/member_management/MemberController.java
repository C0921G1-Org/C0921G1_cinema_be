package C0921G1_sprint_1.controller.member_management;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.Member;

import C0921G1_sprint_1.service.member_management.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/c09/admin/member-management")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //get all members - KhanhLDQ
//    @GetMapping(value = "/member-list")
//    public ResponseEntity<Iterable<Member>> getAllMembers() {
//        List<Member> members = (List<Member>) this.memberService.findAllMembers();
//
//        if (members.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        return new ResponseEntity<>(members,HttpStatus.OK);
//    }

    //get all members with pagination - KhanhLDQ
    @GetMapping(value = "/member-list")
    public ResponseEntity<Page<Member>> getAllMembersWithPagination(
            @PageableDefault(size = 5)Pageable pageable) {
        Page<Member> members = this.memberService.findAllMembersWithPagination(pageable);

        if (members.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    //get member by Id - KhanhLDQ
    @GetMapping(value = "/member-list/info/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id) {
        Optional<Member> memberOptional = this.memberService.findMemberById(id);

        if (!memberOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(memberOptional.get(),HttpStatus.OK);
    }

    //update member by Id - KhanhLDQ
    @PatchMapping(value = "/member-list/update/{id}")
    public ResponseEntity<List<FieldError>> updateMember(@PathVariable String id,
                                                         @RequestBody @Validated MemberDTO memberDTO,
                                                         BindingResult bindingResult) {
//        Optional<Member> memberOptional = this.memberService.findMemberById(id);
//
//        if (!memberOptional.isPresent())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        member.setId(id);
//        this.memberService.saveMember(member);
//        return new ResponseEntity<>(HttpStatus.OK);

        Optional<Member> memberOptional = this.memberService.findMemberById(id);

        if (!memberOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        new MemberDTO().validate(memberDTO,bindingResult);

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);

        memberDTO.setId(id);
        Member member = new Member();
        BeanUtils.copyProperties(memberDTO,member);
        this.memberService.saveMember(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //search member by name - KhanhLDQ
//    @GetMapping(value = "/member-list/search")
//    public ResponseEntity<Page<Member>> getMembersByName(
//            @PageableDefault(size = 5) Pageable pageable,
//            @RequestParam(name = "name", required = false, defaultValue = "") String name
//    ) {
//        System.out.println(name);
//
//        Page<Member> members = this.memberService.findMembersByName(pageable,name);
//
//        if (members.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        return new ResponseEntity<>(members,HttpStatus.OK);
//    }

    //search member by city - KhanhLDQ
//    @GetMapping(value = "/member-list/search")
//    public ResponseEntity<Page<Member>> getMembersByCity(
//            @PageableDefault(size = 5) Pageable pageable,
//            @RequestParam(name = "cityId", required = false) Integer cityId
//    ) {
//        System.out.println(cityId);
//
//        Page<Member> members = this.memberService.findMembersByCity(pageable,cityId);
//
//        if (members.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        return new ResponseEntity<>(members,HttpStatus.OK);
//    }

    //search member by point range - KhanhLDQ
    @GetMapping(value = "/member-list/search")
    public ResponseEntity<Page<Member>> getMembersByPointRange(
            @PageableDefault(size = 5) Pageable pageable,
            @RequestParam(name = "firstValue") Integer firstValue,
            @RequestParam(name = "secondValue") Integer secondValue
    ) {
        System.out.println(firstValue);
        System.out.println(secondValue);

        Page<Member> members = this.memberService.findMembersByPointRange(pageable, firstValue, secondValue);

        if (members.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(members,HttpStatus.OK);
    }


}

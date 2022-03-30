package C0921G1_sprint_1.controller.member_management;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.Member;

import C0921G1_sprint_1.service.member_management.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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

    //get all cities - KhanhLDQ
    @GetMapping(value = "/city-list")
    public ResponseEntity<Iterable<City>> getAllCities() {
        List<City> cities = (List<City>) this.memberService.findAllCities();

        if (cities.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(cities,HttpStatus.OK);
    }

    //get all members with pagination - KhanhLDQ
    @GetMapping(value = "/member-list")
    public ResponseEntity<Page<Member>> getAllMembersWithPagination(
            @RequestParam(name = "page",required = false,defaultValue = "0") Integer page) {

        try {
            Pageable pageable = PageRequest.of(page,5);
            Page<Member> members = this.memberService.findAllMembersWithPagination(pageable);

            if (members.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(members,HttpStatus.OK);
        }
        catch (NullPointerException nullPointerException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    //search members by name and point range - KhanhLDQ
    @GetMapping(value = "/member-list/search")
    public ResponseEntity<Page<Member>> getMembersByNameAndPointRange(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "firstValue", required = false) Integer firstValue,
            @RequestParam(name = "secondValue", required = false) Integer secondValue
    ) {
        try {
            Pageable pageable = PageRequest.of(page,5);
            Page<Member> members = this.memberService.findMembersByNameAndPointRange(
                    pageable,name,firstValue,secondValue);

            if (members.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(members,HttpStatus.OK);
        }
        catch (NullPointerException nullPointerException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

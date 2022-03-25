package C0921G1_sprint_1.controller.member_management;


import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.service.member_management.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "member")

public class MemberController {

    @Autowired
    private MemberService memberService;


    //LongTK lấy ra 1 tài khoản theo id
    @GetMapping("/getDetail/{id}")
    public ResponseEntity<Member> getDetail(@PathVariable String id) {
        if (memberService.findById(id).isPresent()) {
            Member detailMember = memberService.findById(id).get();
            return new ResponseEntity<>(detailMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //LongTK update member
    @PatchMapping( value = "/updateMember/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> updateMember(@PathVariable String id,
                                               @RequestBody MemberDTO memberDTO) {

        System.out.println(memberDTO.toString());
        if (memberService.findById(id).isPresent()) {
            Member updateMember = memberService.findById(id).get();
            BeanUtils.copyProperties(memberDTO, updateMember);

            memberService.save(updateMember);
            return new ResponseEntity<>(updateMember, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


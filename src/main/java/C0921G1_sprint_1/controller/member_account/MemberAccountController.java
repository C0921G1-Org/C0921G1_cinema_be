package C0921G1_sprint_1.controller.member_account;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.Member;

import C0921G1_sprint_1.service.member_account.MemberAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class MemberAccountController {

    @Autowired
    private MemberAccountService memberAccountService;


    //create Stack
    @PostMapping("/member")
    public ResponseEntity createMember(@RequestBody MemberDTO memberObj) {

        Member member = new Member();
        BeanUtils.copyProperties(memberObj, member);
        memberAccountService.createMember(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

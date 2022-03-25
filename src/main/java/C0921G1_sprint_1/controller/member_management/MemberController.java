package C0921G1_sprint_1.controller.member_management;

import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.service.member_management.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/c09/admin/member-management")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //get all members - KhanhLDQ
    @GetMapping(value = "/member-list")
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        List<Member> members = (List<Member>) this.memberService.findAllMembers();

        if (members.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    //get member by Id - KhanhLDQ

}

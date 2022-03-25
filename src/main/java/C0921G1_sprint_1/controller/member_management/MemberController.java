package C0921G1_sprint_1.controller.member_management;

import C0921G1_sprint_1.service.member_management.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c09/member-management")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //get all members - KhanhLDQ


}

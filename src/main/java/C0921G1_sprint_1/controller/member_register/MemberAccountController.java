package C0921G1_sprint_1.controller.member_register;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.Member;

import C0921G1_sprint_1.service.member_account.MemberAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class MemberAccountController {

    @Autowired
    private MemberAccountService memberAccountService;


    //create member NhanNT
    @PostMapping("/member")
    public ResponseEntity<?> createMember(@Validated @RequestBody MemberDTO memberObj,
                                          BindingResult bindingResult ) {

        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberObj, member);
        memberAccountService.createMember(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //get list trading history NhanNT
    @GetMapping("/member/history")
    public ResponseEntity<Iterable<MemberHistoryDTO>> getTradingHistory(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "") String memberID,
                                                                        @RequestParam(defaultValue = "") String filmName){

        Pageable pageable = PageRequest.of(page, 5);
        Page<MemberHistoryDTO> historyDTOList = memberAccountService.findTradingHistory(memberID,filmName,pageable);

        if (historyDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyDTOList, HttpStatus.OK);

    }


}

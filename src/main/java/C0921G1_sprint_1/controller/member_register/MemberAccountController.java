package C0921G1_sprint_1.controller.member_register;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.District;
import C0921G1_sprint_1.model.member.Member;

import C0921G1_sprint_1.model.member.Ward;
import C0921G1_sprint_1.service.member_account.MemberAccountService;
import C0921G1_sprint_1.service.member_management.MemberService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.security.PublicKey;
import java.util.*;

@RestController
@RequestMapping(value = "/c09")
@CrossOrigin(origins = "*")
public class MemberAccountController {

    @Autowired
    private MemberAccountService memberAccountService;



    //create member NhanNT
    @PostMapping(value = "/public/member", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createMember(@Validated @RequestBody MemberDTO memberObj,
                                          BindingResult bindingResult ) {
        new MemberDTO().validate(memberObj,bindingResult);

        Optional<Member> existedEmail = this.memberAccountService.findMemberByEmail(memberObj.getEmail());
        System.out.println(existedEmail);
//        Map<String, String> listErrors = new HashMap<>();
        List<FieldError> listErrors = new ArrayList<>();
        if (bindingResult.hasFieldErrors()){
//            System.out.println(bindingResult.getFieldErrors());

            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.NOT_ACCEPTABLE);
        }
        //check existed member

//        if (this.memberAccountService.findMemberByEmail(memberObj.getEmail()).isPresent()) {
        if (existedEmail.isPresent()) {

            listErrors.add(new FieldError("emailDup", "existedEmail", "Tài khoản đã tồn tại"));
//            listErrors.add("emailDup","existedEmail");
//            System.out.println(listErrors);
            return new ResponseEntity<>(listErrors,HttpStatus.NOT_ACCEPTABLE);
        }
        memberAccountService.createMember(memberObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //    NhanNT lay list city
    @GetMapping("/public/member/city")
    public ResponseEntity<Iterable<City>> getCityList(){
        List<City> cityList = (List<City>) memberAccountService.getListCity();
        if(cityList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cityList,HttpStatus.OK);
    }
    //    NhanNT lay city
    @GetMapping("/public/member/city/{id}")
    public ResponseEntity<City> getCityById(@PathVariable int id){
        City cityById =  memberAccountService.getCityById(id);
        if(cityById == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cityById,HttpStatus.OK);
    }
    //    NhanNT lay list district
    @GetMapping("/public/member/district/{id}")
    public ResponseEntity<Iterable<District>> getDistrictList(@PathVariable int id){
        List<District> districtList = (List<District>) memberAccountService.getListDistrict(id);
        if(districtList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList,HttpStatus.OK);
    }
    //    NhanNT lay list ward
    @GetMapping("/public/member/ward/{id}")
    public ResponseEntity<Iterable<Ward>> getWardList(@PathVariable int id){
        List<Ward> wardList = (List<Ward>) memberAccountService.getListWard(id);
        if(wardList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wardList,HttpStatus.OK);
    }

    //    NhanNT check exist
    @GetMapping("/public/member/email")
//    public ResponseEntity<Member> getMemberByEmail(@PathVariable String email){
    public ResponseEntity<Optional<Member>> getMemberByEmail(@RequestParam(defaultValue = "") String email){
        Optional<Member> email1 =  memberAccountService.findMemberByEmail(email);
        if(!email1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(email1,HttpStatus.OK);
    }



    //get list trading history NhanNT
    @GetMapping("/user/member/history")
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

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}

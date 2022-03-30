package C0921G1_sprint_1.controller.member_register;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.District;
import C0921G1_sprint_1.model.member.Member;

import C0921G1_sprint_1.model.member.Ward;
import C0921G1_sprint_1.service.member_account.MemberAccountService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        new MemberDTO().validate(memberObj,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberObj, member);
        memberAccountService.createMember(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //    NhanNT lay list city
    @GetMapping("/member/city")
    public ResponseEntity<Iterable<City>> getCityList(){
        List<City> cityList = (List<City>) memberAccountService.getListCity();
        if(cityList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(cityList,HttpStatus.OK);
    }
    //    NhanNT lay list district
    @GetMapping("/member/district/{id}")
    public ResponseEntity<Iterable<District>> getDistrictList(@PathVariable int id){
        List<District> districtList = (List<District>) memberAccountService.getListDistrict(id);
        if(districtList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(districtList,HttpStatus.OK);
    }
    //    NhanNT lay list ward
    @GetMapping("/member/ward/{id}")
    public ResponseEntity<Iterable<Ward>> getWardList(@PathVariable int id){
        List<Ward> wardList = (List<Ward>) memberAccountService.getListWard(id);
        if(wardList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(wardList,HttpStatus.OK);
    }


    //get list trading history NhanNT
    @GetMapping("/member/history")
    public ResponseEntity<Iterable<MemberHistoryDTO>> getTradingHistory(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "") String memberID,
                                                                        @RequestParam(defaultValue = "") String filmName){

        Pageable pageable = PageRequest.of(page, 2);
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

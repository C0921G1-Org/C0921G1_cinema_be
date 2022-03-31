package C0921G1_sprint_1.controller.member_management;


import C0921G1_sprint_1.dto.member.MemberAccountDTO;
import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.member_management.MemberService;
import C0921G1_sprint_1.service.transaction_service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("member")

public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TransactionService transactionService;

    private boolean isIdWrong(String id) {
        return !memberService.findById(id).isPresent() || id == null || id.equals("");
    }

    private boolean isDateWrong(String startDate, String endDate) {
        return startDate == null || endDate == null || startDate.equals("") || endDate.equals("");
    }


    //LongTK lấy ra 1 tài khoản theo id
    @GetMapping("/getDetail/{id}")
    public ResponseEntity<Member> getDetail(@PathVariable String id) {

        if (isIdWrong(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (memberService.findById(id).isPresent()) {
            Member detailMember = memberService.findById(id).get();
            return new ResponseEntity<>(detailMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //LongTK update member method
    @PatchMapping(value = "/updateMember", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> updateMember(@Validated @RequestBody MemberDTO memberDTO, BindingResult
            bindingResult) {

        new MemberDTO().validate(memberDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            String id = memberDTO.getId();
            System.out.println("rest controller : " + memberDTO.toString());
            if (memberService.findById(id).isPresent()) {

                Member updateMember = memberService.findById(id).get();
                BeanUtils.copyProperties(memberDTO, updateMember);
                System.out.println("member after update: " + updateMember.toString());

                memberService.save(updateMember);

                return new ResponseEntity<>(updateMember, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * lấy ra tổng tiền dịch vụ và tiền ghế rồi convert thành điểm
     */

    public Double letTotal(Integer transactionId, String startDate, String endDate) {
        //Lấy ra tổng tiền dịch vụ
        double sumAttachServicePrice = 0.0;
        List<Double> attachServicePrice = transactionService.getAllAttachServicePrice(transactionId, startDate, endDate);
        for (Double ase : attachServicePrice) {
            if (ase == null) {
                ase = 0.0;
            }
            System.out.println(transactionId + " - " + startDate + " - " +endDate);
            sumAttachServicePrice += ase;
        }
        System.out.println("attach service total: " + sumAttachServicePrice);

        //Lấy ra tổng tiền ghế
        double sumSeatPrice = 0.0;
        List<Double> seatPrice = transactionService.getSeatPrice(transactionId, startDate, endDate);
        for (Double seat : seatPrice) {
            System.out.println("seat price :: " + seat);
            sumSeatPrice += seat;
        }

        //tổng lại chia 10000, tỷ lệ 10000vnd = 1 điểm
        double totalPoint = (sumAttachServicePrice + sumSeatPrice) / 10000;

        return totalPoint;
    }

    /**
     * Xem lịch sử  công điểm LongTK
     */
    @GetMapping("/viewHistory/gained/{id}")
    public ResponseEntity<Page<Transaction>> viewGainedPointHistory(@PathVariable String id,
                                                                    @RequestParam String startDate,
                                                                    @RequestParam String endDate,
                                                                    @RequestParam int pageNo) {
//        List<Double> attachServicePrice = transactionService.getAllAttachServicePrice(id, startDate, endDate);
//        if (attachServicePrice.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        if (isDateWrong(startDate, endDate)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        //lấy ra danh sách giao dịch
        Pageable pageable = PageRequest.of(pageNo, 10);
        Page<Transaction> history = transactionService.getGainedPointTransaction(id, startDate, endDate, pageable);

        //trả về kết quả
        if (history.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            //set số điểm nhận dc thông qua cho giao dịch
            for (Transaction t : history) {
                System.out.println("__________________" +t.getId());
                t.setPointGained(letTotal(t.getId(),startDate,endDate));
                System.out.println(letTotal(t.getId(),startDate,endDate));
                System.out.println("----");
                System.out.println(t.getShowTime().getFilm().getName());
            }
            return new ResponseEntity<>(history, HttpStatus.OK);
        }
    }

    /**
     * xem lịch sử dùng điểm
     */
    @GetMapping("/viewHistory/used/{id}")
    public ResponseEntity<Page<Transaction>> viewUsedPointHistory(@PathVariable String id,
                                                                  @RequestParam String startDate,
                                                                  @RequestParam String endDate,
                                                                  @RequestParam int pageNo) {

//        List<Double> attachServicePrice = transactionService.getAllAttachServicePrice(id, startDate, endDate);
//        if (attachServicePrice.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        if (isIdWrong(id) || isDateWrong(startDate, endDate)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Pageable pageable = PageRequest.of(pageNo, 10);
        if (memberService.findById(id).isPresent()) {
            Page<Transaction> usedPointHistory = transactionService.getUsedPointTransaction(id, startDate, endDate, pageable);
            if (usedPointHistory.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(usedPointHistory, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //chức năng đổi pass chưa code được vì còn dính mã hóa password bên security của TuNK
    @PatchMapping(value = "/changePassword/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> changePassword(@RequestBody MemberAccountDTO accountDTO,
                                                 BindingResult bs,
                                                 @PathVariable String id) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Đổi điểm lấy mã giảm giá
     */
    @PostMapping(value = "/tradingPoint/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> tradingPoint(@PathVariable String id) {
        Double currentPoint;
        if (memberService.findById(id).isPresent()) {
            Member member = memberService.findById(id).get();
            currentPoint = member.getPoint();

            //cho một phiếu giảm giá tương ứng 100 điểm
            if (currentPoint - 100 >= 0) {

                //update lại điểm sau khi tiêu hao của member
                member.setPoint(currentPoint - 100);
                memberService.save(member);

                //tạo transaction cho lịch sử dùng điểm đổi mã
                Transaction usedPointTransaction = new Transaction();
                usedPointTransaction.setMember(member);

                String transactionDate = String.valueOf(java.time.LocalDate.now());
                usedPointTransaction.setTransactionalDate(transactionDate);

                //mã giảm giá có định dạng c09XXXXX
                //thêm vào trong transaction vừa tạo
                int randomCode = (int) (Math.random() * 99999 - 10000 + 1) + 10000;
                String promotionCode = "c09" + randomCode;
                System.out.println(promotionCode);
                usedPointTransaction.setTicketStatus(promotionCode);

                //set show time = -1
                //giao dịch nhận điểm hoàn toàn tách biệt với giao dịch dùng điểm
                ShowTime st = new ShowTime();
                st.setId(-1);
                usedPointTransaction.setShowTime(st);

                transactionService.saveUsedPointTransaction(usedPointTransaction);

                //ai làm chức năng dùng mã giảm giá để thanh toán thì nhớ set ticket_status về null
                return new ResponseEntity<>(promotionCode, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Bạn không đủ điểm để đổi mã!", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


package C0921G1_sprint_1.controller.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.order_ticket.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/BookingTicket")
public class BookingController {
    @Autowired
    BookingService bookingService;

    //    Hiển thị list của trang quản lí danh sách đặt vé : AnhVN
    @GetMapping(value = "/List")
    public ResponseEntity<Page<Transaction>> getListTransaction(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Transaction> transactionPage = bookingService.findAll(pageable);
        if (transactionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionPage, HttpStatus.OK);
    }

    //    Tìm kiếm theo nhiều trường : AnhVN
    @GetMapping(value = "/Search")
    public ResponseEntity<Page<Transaction>> searchBookingTicket(@RequestParam(defaultValue = "0") Integer pageable,
                                                                 @RequestParam(defaultValue = "") String code,
                                                                 @RequestParam(defaultValue = "") String name,
                                                                 @RequestParam(defaultValue = "") String member_id,
                                                                 @RequestParam(defaultValue = "") String phone
    ) {
        Pageable pageable1 = PageRequest.of(pageable, 10);

        Page<Transaction> transactionsListSearch = bookingService.findAllTransactionSearch(code, name, member_id, phone, pageable1);
//        if (transactionsListSearch.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(transactionsListSearch, HttpStatus.OK);
    }


//AnhVN
//    @GetMapping(value = "/ConfirmTicket")
//    public ResponseEntity<Page<Transaction>> confirmTicket(@PageableDefault(value = 5) Pageable pageable) {
//        Page<Transaction> transactions = this.bookingService.getAllConfirmPage(pageable);
//        if (transactions.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(transactions, HttpStatus.OK);
//    }


    //    Hiển thị thông tin của trang xác nhận nhận vé : AnhVN
    @GetMapping(value = "/Confirm/{id}")
    public ResponseEntity<Transaction> getConfirmTransaction(@PathVariable Integer id) {
        Optional<Transaction> transObj = this.bookingService.findById(id);
        if (!transObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(transObj.get(), HttpStatus.OK);
    }


    // Cập nhật trạng thái xác nhận của vé : AnhVN
    @PatchMapping(value = "/Update")
    public ResponseEntity<?> accepTicket(@RequestBody Transaction transaction) {
        transaction.setCheckAcceptTicket(1);
        bookingService.acceptTicket(transaction);
        return ResponseEntity.ok().build();
    }
}

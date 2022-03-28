package C0921G1_sprint_1.controller.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.order_ticket.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Page<Transaction>> searchBookingTicket(@PageableDefault(value = 0) Pageable pageable,
                                                                 @RequestParam(defaultValue = "") String code,
                                                                 @RequestParam(defaultValue = "") String name,
                                                                 @RequestParam(defaultValue = "") String member_id,
                                                                 @RequestParam(defaultValue = "") String phone
    ) {
        System.out.println("TestSearch");
        Page<Transaction> transactionsListSearch = bookingService.findAllTransactionSearch(pageable, code,name, member_id, phone);
        System.out.println(transactionsListSearch);
        if (transactionsListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionsListSearch, HttpStatus.OK);
    }

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
        return new ResponseEntity<>((Transaction) transObj.get(), HttpStatus.OK);
    }
}

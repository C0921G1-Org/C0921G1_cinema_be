package C0921G1_sprint_1.controller.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.order_ticket.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookingTicket")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Transaction>> getListCategory(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Transaction> transactionPage = bookingService.findAll(pageable);
        if (transactionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionPage, HttpStatus.OK);

    }
}

package C0921G1_sprint_1.controller.special_ticket_confirmation;


import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.special_ticket_confirmation.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/pay")
    public ResponseEntity<List<Transaction>> listResponseEntity(){
        List<Transaction> transactions = paymentService.getAllTransaction();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}

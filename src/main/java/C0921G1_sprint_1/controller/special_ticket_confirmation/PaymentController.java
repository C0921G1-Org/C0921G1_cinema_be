package C0921G1_sprint_1.controller.special_ticket_confirmation;


import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.service.special_ticket_confirmation.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addTracsaction(@RequestBody Transaction transaction){
     return new ResponseEntity<>(paymentService.saveTransaction(transaction) , HttpStatus.OK);
    }
}

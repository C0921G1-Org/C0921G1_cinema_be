package C0921G1_sprint_1.service.special_ticket_confirmation;

import C0921G1_sprint_1.model.transaction.Transaction;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Transaction>  getAllTransaction();
    Transaction saveTransaction(Transaction transaction);
}

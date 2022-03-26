package C0921G1_sprint_1.service.special_ticket_confirmation;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Override
    public List<Transaction> getAllTransaction() {
        return null;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return null;
    }
}

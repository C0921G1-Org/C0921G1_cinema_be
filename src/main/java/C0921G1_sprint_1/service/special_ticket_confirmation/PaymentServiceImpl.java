package C0921G1_sprint_1.service.special_ticket_confirmation;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.repository.special_ticket_confirmation.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Transaction> getAllTransaction() {
        return paymentRepository.findAll();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return paymentRepository.save(transaction);
    }

}

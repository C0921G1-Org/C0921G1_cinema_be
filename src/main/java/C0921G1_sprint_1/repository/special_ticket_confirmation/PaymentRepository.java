package C0921G1_sprint_1.repository.special_ticket_confirmation;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PaymentRepository extends JpaRepository<Transaction,Integer> {
}

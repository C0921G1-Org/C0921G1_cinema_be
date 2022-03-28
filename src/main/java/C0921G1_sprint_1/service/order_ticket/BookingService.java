package C0921G1_sprint_1.service.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Page<Transaction> findAll(Pageable pageable);
    Page<Transaction> findAllTransactionSearch(Pageable pageable, String code, String name, String memeber_id, String phone);
//    Page<Transaction> getAllConfirmPage(Pageable page);

    Optional<Transaction> findById(Integer id);
}
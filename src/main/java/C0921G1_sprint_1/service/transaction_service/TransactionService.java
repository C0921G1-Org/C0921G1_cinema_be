package C0921G1_sprint_1.service.transaction_service;
import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {
    Page<Transaction> getGainedPointTransaction(String memeberId, String startDate, String endDate,  Pageable pageable);

    Page<Transaction> getUsedPointTransaction(String memeberId, String startDate, String endDate, Pageable pageable);

    List<Double> getAllAttachServicePrice(Integer transationId, String startDate, String endDate);

    List<Double> getSeatPrice(Integer transationId, String startDate, String endDate);

    void saveUsedPointTransaction(Transaction transaction);
}

package C0921G1_sprint_1.service.transaction_service;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public Page<Transaction> getGainedPointTransaction(String memeberId, String startDate, String endDate, Double total, Pageable pageable) {
        List<Transaction> transactionsList = new ArrayList<>();
        Page<Transaction> page = new PageImpl<>(transactionsList);
        if (memeberId == null) {
            return page;
        }
        return transactionRepository.getGainedPointTransaction(memeberId, startDate, endDate, total, pageable);
    }

    @Override
    public Page<Transaction> getUsedPointTransaction(String memeberId, String startDate, String endDate, Pageable pageable) {
        List<Transaction> transactionsList = new ArrayList<>();
        Page<Transaction> page = new PageImpl<>(transactionsList);
        if (memeberId == null) {
            return page;
        }
        return transactionRepository.getUsedPoint(memeberId, startDate, endDate, pageable);
    }

    @Override
    public List<Double> getAllAttachServicePrice(String memeberId, String startDate, String endDate) {
        return transactionRepository.getAttachServicePrice(memeberId, startDate, endDate);
    }

    @Override
    public List<Double> getSeatPrice(String memeberId, String startDate, String endDate) {
        return transactionRepository.getSeatPrice(memeberId, startDate, endDate
        );
    }

    @Override
    public void saveUsedPointTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}

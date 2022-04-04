package C0921G1_sprint_1.service.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookingService {
    //    Phương thức findAll của AnhVN
    Page<Transaction> findAll(Pageable pageable);

    //    Phương thức Search Transaction của AnhVN
    Page<Transaction> findAllTransactionSearch(String code, String name, String memeber_id, String phone, Pageable pageable);
//    Page<Transaction> getAllConfirmPage(Pageable page);

    //    Phương thức tìm kiếm qua id của AnhVN
    Optional<Transaction> findById(Integer id);

    //    Phương thức thay đổi trạng thái đối tượng AnhVN
    void acceptTicket(Transaction transaction);
}
package C0921G1_sprint_1.service.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.repository.order_ticket.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    //    Gọi repository AnhVN
    @Autowired
    private BookingRepository bookingRepo;

    //    Phương thức findAll với tham số Pageable của AnhVN
    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return bookingRepo.findAll(pageable);
    }

    //    Phương thức tìm kiếm với 4 trường của AnhVN
    @Override
    public Page<Transaction> findAllTransactionSearch(String code, String name, String member_id, String phone, Pageable pageable) {
        return bookingRepo.searchBookingTicket(code, name, member_id, phone, pageable);
    }

    //    Phương thức tìm kiếm thông qua id AnhVN
    @Override
    public Optional<Transaction> findById(Integer id) {
        return bookingRepo.findById(id);
    }


    //    Phương thức cập nhật trạng thái của vé AnhVN
    @Override
    public void acceptTicket(Transaction transaction) {
        bookingRepo.save(transaction);
    }


//    @Override
//    public Page<Transaction> getAllConfirmPage(Pageable page){
//        return this.bookingRepo.getAllConfirmPage(page);
//    }
}

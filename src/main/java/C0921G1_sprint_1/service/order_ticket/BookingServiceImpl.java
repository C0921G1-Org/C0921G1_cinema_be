package C0921G1_sprint_1.service.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.repository.order_ticket.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepository bookingRepo;

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return bookingRepo.findAll(pageable);
    }
}

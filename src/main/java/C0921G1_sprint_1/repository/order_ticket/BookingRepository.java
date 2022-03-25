package C0921G1_sprint_1.repository.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "Select t.code, m.id, m.name, m.identity_number, m.phone, f.name, t.`transactional_date`, st.name\n" +
            "From `transaction` as t\n" +
            "Join show_time st on t.show_time_id = st.id\n" +
            "Join film f on st.film_id = f.id\n" +
            "Join member m on m.id = t.member_id",nativeQuery = true)
    Page<Transaction> findAll(Pageable pageable);
}

package C0921G1_sprint_1.repository.special_ticket_confirmation;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Transaction,Integer> {
//
//    @Query(value="Select * \n" +
//            "From member m \n" +
//            "join transaction t on t.member_id = m.id\n" +
//            "join show_time st on t.show_time_id = st.id\n" +
//            "join screen s on s.id = st.screen_id\n" +
//            "join film f on st.film_id = f.id\n" +
//            "join selected_seat se on se.show_time_id = st.id\n" +
//            "join seat_type sety on  sety.id = se.seat_type_id\n" +
//            "join attached_service ats on ats.transaction_id = t.id\n" +
//            "where t.id = ?1" , nativeQuery = true)
//    Transaction transactionById(Integer id);
}

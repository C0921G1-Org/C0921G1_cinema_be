package C0921G1_sprint_1.repository.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "Select t.id, t.code , t.member_id, t.show_time_id , m.name, m.identity_number, m.phone, f.name as name_member, t.`transactional_date`, st.name as time, t.ticket_status\n" +
            "From `transaction` as t\n" +
            "Join show_time st on t.show_time_id = st.id\n" +
            "Join film f on st.film_id = f.id\n" +
            "Join member m on m.id = t.member_id",nativeQuery = true)
    Page<Transaction> findAll(Pageable pageable);

//    @Query(value = "select * from transaction where code like concat('%',code,'%')", nativeQuery = true)
    @Query(value = "Select t.id as id_transation, t.code , t.show_time_id, st.id, t.`transactional_date` , st.name as time , seatt.name as name_seat, seatt.price, t.member_id,m.identity_number, m.name, m.point , t.ticket_status, m.phone\n" +
            "From `transaction` as t\n" +
            "Join show_time st on t.show_time_id = st.id\n" +
            "Join film f on st.film_id = f.id\n" +
            "Join member m on m.id = t.member_id\n" +
            "Join seat_type seatt on seatt.id = seatt.id\n" +
            "\n" +
            " where code like %:code%  and  m.name like %:name% and member_id like %:member_id% and m.phone like %:phone% " +
            " group by id_transation", nativeQuery = true)
    Page<Transaction> searchBookingTicket(Pageable pageable, @Param("code") String code, @Param("name") String name, @Param("member_id") String member_id, @Param("phone") String phone);


//    @Query(value = "Select t.id as id_transation, t.code , t.show_time_id, st.id, t.`transactional_date` , st.name as time , seatt.name as name_seat, seatt.price, t.member_id,m.identity_number, m.name, m.point , t.ticket_status, m.phone\n" +
//            "From `transaction` as t\n" +
//            "Join show_time st on t.show_time_id = st.id\n" +
//            "Join film f on st.film_id = f.id\n" +
//            "Join member m on m.id = t.member_id\n" +
//            "Join seat_type seatt on seatt.id = seatt.id", nativeQuery = true)
//    Page<Transaction> getAllConfirmPage(Pageable page);
}

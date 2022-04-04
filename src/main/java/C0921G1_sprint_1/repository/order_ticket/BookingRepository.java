package C0921G1_sprint_1.repository.order_ticket;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Transaction, Integer> {
    //    Hiển thị list (CŨ)
//    @Query(value = "Select t.id, t.code , t.member_id, t.show_time_id , m.name, m.identity_number, m.phone, f.name as name_member, t.`transactional_date`,st.date, st.name as time, t.ticket_status\n" +
//            "From `transaction` as t\n" +
//            "Join show_time st on t.show_time_id = st.id\n" +
//            "Join film f on st.film_id = f.id\n" +
//            "Join member m on m.id = t.member_id " +
//            " group by t.id " +
//            " order by t.id", nativeQuery = true)
//    Page<Transaction> findAll(Pageable pageable);

    //Truy Vấn tìm kiếm 4 trường (Cũ)
//    @Query(value = "select * from transaction where code like concat('%',code,'%')", nativeQuery = true)

     //Truy Vấn tìm kiếm 4 trường (Cũ)
//    @Query(value = "Select t.id as id_transation, t.code , t.show_time_id, st.id, t.`transactional_date` , st.name as time , seatt.name as name_seat, seatt.price, t.member_id,m.identity_number, m.name, m.point , t.ticket_status, m.phone \n" +
//            " From `transaction` as t \n" +
//            " Join show_time st on t.show_time_id = st.id \n" +
//            " Join film f on st.film_id = f.id \n" +
//            " Join member m on m.id = t.member_id \n" +
//            " Join seat_type seatt on seatt.id = seatt.id \n" +
//            "\n" +
//            " where code like \" %:code% \"  and  \"m.name\" like \" %:name% \" and member_id like \" %:member_id% \" and m.phone like \" %:phone% \" \n" +
//            " group by id_transation ", nativeQuery = true)
//    Page<Transaction> searchBookingTicket(Pageable pageable, @Param("code") String code, @Param("name") String name, @Param("member_id") String member_id, @Param("phone") String phone);


    //        Query search + list AnhVN
    @Query(value = "Select *\n" +
            "             From transaction \n" +
            "            Join show_time  on transaction.show_time_id = show_time.id \n" +
            "             Join film on show_time.film_id = film.id \n" +
            "            Join member on member.id = transaction.member_id \n" +
            "             where transaction.code like %?1% and member.name like %?2% and member.id like %?3% and member.phone like %?4% " +
            "    group by transaction.id " +
            " order by transaction.id",
            countQuery = "Select count(*) \n" +
                    "             From transaction \n" +
                    "            Join show_time  on transaction.show_time_id = show_time.id\n" +
                    "             Join film on show_time.film_id = film.id\n" +
                    "            Join member on member.id = transaction.member_id\n" +
                    "             where transaction.code like %?1% and member.name like %?2% and member.id like %?3% and member.phone like %?4% " +
                    "  group by transaction.id " +
                    " order by transaction.id"
            , nativeQuery = true)
    Page<Transaction> searchBookingTicket(String code, String name, String id, String phone, Pageable pageable);


}



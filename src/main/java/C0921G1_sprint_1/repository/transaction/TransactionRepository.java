package C0921G1_sprint_1.repository.transaction;

import C0921G1_sprint_1.model.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    /**
     * Bởi vì mã giảm giá có dạng c09XXXXX nên cái nào không có tức là không phải loại giao dịch dùng điểm
     */
    @Query(value = " SELECT * FROM `transaction` " +
            " where member_id =  :memberId " +
            " and transactional_date " +
            " BETWEEN :startDate " +
            " AND :endDate " +
            " and ticket_status is null " +
            " GROUP BY `transaction`.id ",
            nativeQuery = true)
    Page<Transaction> getGainedPointTransaction(@Param("memberId") String memberId,
                                                @Param("startDate") String startDate,
                                                @Param("endDate") String endDate,
                                                Pageable page);


    /**
     * Lấy ra tổng tiền dịch vụ đi kèm
     */
    @Query(value = " Select  ats.price `attached_price` " +
            "-- select *\n" +
            " From `member` m\n" +
            " join `transaction` t on t.member_id = m.id\n" +
            " join show_time st on t.show_time_id = st.id\n" +
            " \n" +
            " -- join ticket tk on tk.transaction_id = t.id\n" +
            " join selected_seat se on se.show_time_id = st.id\n" +
            " join seat_type sety on  sety.id = se.seat_type_id\n" +
            " join attached_service ats on ats.transaction_id = t.id\n" +
            " where transaction_id = :transaction_id  and transactional_date BETWEEN  :startDate   AND  :endDate ",
            nativeQuery = true)
    List<Double> getAttachServicePrice(@Param("transaction_id") Integer transaction_id,
                                       @Param("startDate") String startDate,
                                       @Param("endDate") String endDate);


    /**
     * Lấy ra tổng tiền ghế
     */
    @Query(value = "  SELECT stype.price from selected_seat ss join seat_type stype on ss.id =  stype.id join show_time on ss.show_time_id = show_time.id " +
            " join transaction t on t .show_time_id = show_time.id where t.id = :transactionId and transactional_date BETWEEN :startDate and :endDate",
            nativeQuery = true)
    List<Double> getSeatPrice(@Param("transactionId") Integer transactionId,
                              @Param("startDate") String startDate,
                              @Param("endDate") String endDate);


    /**
     * xem lịch sử dùng điểm
     */
    @Query(value = " SELECT  * " +
            "  FROM `transaction` t\n" +
            " where member_id = :memberId   and transactional_date  BETWEEN :startDate   AND  :endDate" +
            " and ticket_status LIKE '%c09%' ORDER BY  transactional_date asc  " ,

            nativeQuery = true)
    Page<Transaction> getUsedPoint(@Param("memberId") String memberId,
                                   @Param("startDate") String startDate,
                                   @Param("endDate") String endDate,
                                   Pageable page);


}



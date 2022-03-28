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
    @Query(value = " SELECT *, :totalPrice as total FROM `transaction` " +
            " where member_id =  :memberId " +
            " and transactional_date " +
            " BETWEEN :startDate " +
            " AND :endDate " +
            " and ticket_status not LIKE '%c09%' " +
            " GROUP BY `transaction`.id ",
            nativeQuery = true)
    Page<Transaction> getGainedPointTransaction(@Param("memberId") String memberId,
                                                @Param("startDate") String startDate,
                                                @Param("endDate") String endDate,
                                                @Param("totalPrice") Double totalPrice,
                                                Pageable page);


    /**
     * Lấy ra tổng tiền dịch vụ đi kèm
     */
    @Query(value = " SELECT DISTINCT ase.price " +
            " FROM `transaction` t " +
            " LEFT JOIN attached_service ase  " +
            " on ase.transaction_id = t.id " +
            " LEFT join show_time st on t.show_time_id = st.id " +
            " LEFT JOIN selected_seat ss on ss.show_time_id = st.id " +
            " LEFT join seat_type s_type on s_type.id = ss.seat_type_id  " +
            " where member_id = :memberId  " +
            " and transactional_date  " +
            " BETWEEN :startDate " +
            " AND :endDate " +
            " AND ticket_status not LIKE '%c09%' " +
            " GROUP BY ase.name ",
            nativeQuery = true)
    List<Double> getAttachServicePrice(@Param("memberId") String memberId,
                                       @Param("startDate") String startDate,
                                       @Param("endDate") String endDate);


    /**
     * Lấy ra tổng tiền ghế
     */
    @Query(value = " SELECT   DISTINCT s_type.price\n" +
            "  FROM `transaction` t\n" +
            " LEFT JOIN attached_service ase \n" +
            " on ase.transaction_id = t.id\n" +
            " LEFT join show_time st on t.show_time_id = st.id\n" +
            " LEFT JOIN selected_seat ss on ss.show_time_id = st.id\n " +
            " LEFT join seat_type s_type on s_type.id = ss.seat_type_id \n " +
            " where member_id = :memberId   and transactional_date  BETWEEN :startDate   AND  :endDate" +
            " AND ticket_status not LIKE '%c09%'  " +
            "GROUP BY s_type.name",
            nativeQuery = true)
    List<Double> getSeatPrice(@Param("memberId") String memberId,
                              @Param("startDate") String startDate,
                              @Param("endDate") String endDate);


    /**
     * xem lịch sử dùng điểm
     */
    @Query(value = " SELECT  * " +
            "  FROM `transaction` t\n" +
            " LEFT JOIN attached_service ase \n" +
            " on ase.transaction_id = t.id\n" +
            " LEFT join show_time st on t.show_time_id = st.id\n" +
            " LEFT JOIN selected_seat ss on ss.show_time_id = st.id\n " +
            " LEFT join seat_type s_type on s_type.id = ss.seat_type_id \n " +
            " where member_id = :memberId   and transactional_date  BETWEEN :startDate   AND  :endDate" +
            " and ticket_status LIKE '%c09%'  " +
            "GROUP BY s_type.name",
            nativeQuery = true)
    Page<Transaction> getUsedPoint(@Param("memberId") String memberId,
                                   @Param("startDate") String startDate,
                                   @Param("endDate") String endDate,
                                   Pageable page);


}



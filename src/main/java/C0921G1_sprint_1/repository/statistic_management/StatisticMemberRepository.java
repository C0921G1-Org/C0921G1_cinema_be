package C0921G1_sprint_1.repository.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopMember;
import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticMemberRepository extends JpaRepository<Member,String> {
    @Query(value = " Select  " +
            " `member`.id, " +
            " `member`.`name`,  " +
            " count(ticket.seat_id) As totalTicket, " +
            " SUM(seat_type.price) AS totalMoney, " +
            " `member`.point " +
            "    From `member`  " +
            "        left join `transaction` on `transaction`.member_id = `member`.id " +
            "        left join ticket on `transaction`.id = ticket.transaction_id " +
            "        left join seat on seat.id = ticket.seat_id " +
            " join seat_type on seat_type.id = seat.seat_type_id " +
            " Group by `member`.id " +
            " Order by totalMoney " +
            " Limit 10;  ", nativeQuery = true)
    List<TopMember> findAllTopMember();
}

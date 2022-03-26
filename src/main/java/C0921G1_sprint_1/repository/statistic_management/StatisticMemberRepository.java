package C0921G1_sprint_1.repository.statistic_management;

import C0921G1_sprint_1.dto.statistic.TopMember;
import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface StatisticMemberRepository extends JpaRepository<Member, String> {

    @Query(value = " Select " +
            " `member`.id, " +
            " `member`.`name`, " +
            " COUNT(selected_seat.id) As totalTicket, " +
            " SUM(seat_type.price) AS totalMoney,  " +
            " `member`.point " +
            "  From `member`  " +
            "       left join `transaction` on `transaction`.member_id = `member`.id " +
            "       left join show_time on `transaction`.show_time_id = show_time.id " +
            "       left join selected_seat on selected_seat.show_time_id = show_time.id " +
            "       join seat_type on seat_type.id = selected_seat.seat_type_id " +
            "   Where year(`transaction`.transactional_date) like concat('%',:year,'%')" +
            " Group by `member`.id " +
            " Order by totalMoney " +
            " Limit 10; "
            , nativeQuery = true)
    List<TopMember> findAllTopMemberByYear(@RequestParam("year") String year);

    @Query(value = " Select " +
            " `member`.id, " +
            " `member`.`name`, " +
            " COUNT(selected_seat.id) As totalTicket, " +
            " SUM(seat_type.price) AS totalMoney,  " +
            " `member`.point " +
            "  From `member`  " +
            "       left join `transaction` on `transaction`.member_id = `member`.id " +
            "       left join show_time on `transaction`.show_time_id = show_time.id " +
            "       left join selected_seat on selected_seat.show_time_id = show_time.id " +
            "       join seat_type on seat_type.id = selected_seat.seat_type_id " +
            "  Where " +
            "    (month(`transaction`.transactional_date) between :monthStart and :monthEnd) and" +
            "    year(`transaction`.transactional_date) like concat('%',:year,'%') " +
            " Group by `member`.id " +
            " Order by totalMoney " +
            " Limit 10; "
            , nativeQuery = true)
    List<TopMember> findAllTopMemberByQuarterAndYear(
            @RequestParam("monthStart") String monthStart,
            @RequestParam("monthEnd") String monthEnd,
            @RequestParam("year") String year
    );
}

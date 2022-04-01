package C0921G1_sprint_1.repository.statistic_management;

import C0921G1_sprint_1.dto.statistic.Revenue;
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
    @Query(value = " select year(`transactional_date`) " +
            "from `transaction` " +
            "group by year(`transactional_date`)" +
            "order by year(`transactional_date`) desc"
            , nativeQuery = true)
    List<String> getYear();
    @Query(value = " Select transactional_date as `date`, " +
            "SUM(seat_type.price + ifnull(attached_service.price,0)) AS totalMoney " +
            "    From `transaction` " +
            "        left join show_time on `transaction`.show_time_id = show_time.id " +
            "        left join selected_seat on selected_seat.show_time_id = show_time.id " +
            " left join seat_type on seat_type.id = selected_seat.seat_type_id\n" +
            " left join attached_service on attached_service.transaction_id = `transaction`.id " +
            "        where year(`transaction`.transactional_date)= year(curdate()) and month(`transaction`.transactional_date)= month(curdate()) " +
            " Group by transactional_date" +
            " Order by transactional_date ; "
            , nativeQuery = true)
    List<Revenue> getRevenueByMonth();

}
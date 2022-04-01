package C0921G1_sprint_1.repository.member_account;

import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberAccountRepository extends JpaRepository<Member, String> {
    // NhanNT query Trading History
    @Query(value =
        "Select t.transactional_date `transactionalDate`, t.`code` , s.`name` `screenName` , f.`name` `filmName`, sum(sety.price) `ticketPrice`, m.`point` \n" +
        "From `member` m \n" +
        "join `transaction` t on t.member_id = m.id\n" +
        "join show_time st on t.show_time_id = st.id \n" +
        "join screen s on s.id = st.screen_id \n" +
        "join film f on st.film_id = f.id \n" +
        "join selected_seat se on se.show_time_id = st.id \n" +
        "join seat_type sety on  sety.id = se.seat_type_id \n" +
        "where m.id = ?1 and f.`name` like %?2% \n" +
        "group by t.transactional_date", nativeQuery = true)
    Page<MemberHistoryDTO> findTradingHistory(String id, String filmName, Pageable pageable);


    // NhanNT query Create account
    @Modifying
    @Transactional
    @Query(value =
            "insert into c0921g1_sprint_1.account_role(account_id,role_id)\n" +
                    "values (?1,2);"
            , nativeQuery = true)
    void createAccount(int account_id);


}

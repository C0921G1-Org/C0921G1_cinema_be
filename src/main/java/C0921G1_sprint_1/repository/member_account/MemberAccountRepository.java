package C0921G1_sprint_1.repository.member_account;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sun.applet.resources.MsgAppletViewer_es;

@Repository
public interface MemberAccountRepository extends JpaRepository<Member,String> {


    // NhanNT query Trading History
    @Query(value =
            "Select t.transactional_date , t.`code` , s.`name` `screenName` , f.`name` `filmName`, sety.price `ticketPrice`, ats.price `attachedPrice`, m.`point` \n" +
                    "From `member` m \n" +
                    "Join `transaction` t on t.member_id = m.id \n"+
                    "Join show_time st on t.show_time_id = st.id \n"+
                    "Join screen s on s.id = st.screen_id \n"+
                    "Join film f on st.film_id = f.id \n"+
                    "Join ticket tk on tk.transaction_id = t.id \n"+
                    "Join seat se on se.id = tk.seat_id \n"+
                    "Join seat_type sety on  sety.id = se.seat_type_id \n"+
                    "Join attached_service ats on ats.transaction_id = t.id \n"+
                    "where m.id = ?1 and f.`name` like %?2%"

            , nativeQuery = true)
    Page<MemberHistoryDTO>findTradingHistory(String id,String filmName, Pageable pageable);

    // NhanNT query Create Member
//    @Query(value =
//            "insert into c0921g1_sprint_1.member(address, date_of_birth, email, gender, identity_number, image, `name`, phone, `point`, city_id)\n" +
//                    "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10);"
//            , nativeQuery = true)
//    void createMember(String address, String dob, String email, int gender, String identityNumber, String image, String name, String phone, double point, int city);



}

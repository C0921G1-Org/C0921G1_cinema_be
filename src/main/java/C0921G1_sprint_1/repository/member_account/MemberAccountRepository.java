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
            "Select t.transactional_date, t.code, s.name, f.name, se.transaction_id, st.price, ats.price, m.point \n" +
                    "From transaction t \n" +
                    "Join show_time st on t.show_time_id = st.id \n"+
                    "Join film f on st.film_id = f.id \n"+
                    "Join screen s on s.show_time_id = st.id \n"+
                    "Join member m on m.id = t.member_id \n"+
                    "Join seat se on se.transaction_id = t.id \n"+
                    "Join seat_type set on se.seat_type_id = set.id \n"+
                    "Join attached_service ats on ats.transaction_id = t.id \n"+
                    "where m.id = ?1;"
            , nativeQuery = true)
    Page<MemberHistoryDTO>findTradingHistory(Integer customerTypeId, Pageable pageable);

    // NhanNT query Create Member
    @Query(value =
            "insert into c0921g1_sprint_1.member(address, date_of_birth, email, gender, identity_number, image, `name`, phone, `point`, city_id)\n" +
                    "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10);"
            , nativeQuery = true)
    void createMember(String address, String dob, String email, int gender, String identityNumber, String image, String name, String phone, double point, int city);



}

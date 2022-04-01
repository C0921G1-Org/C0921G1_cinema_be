package C0921G1_sprint_1.controller.member_history;

import C0921G1_sprint_1.controller.member_register.MemberAccountController;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest
public class MemberAccountController_memberHistory {
    @Autowired
    private MemberAccountController memberAccountController;

    //    NhanNT test list =0
    @Test
    public void getListStudent_5() {

        ResponseEntity<Iterable<MemberHistoryDTO>> responseEntity
                = this.memberAccountController.getTradingHistory(0,"Mem-001","bal");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //    NhanNT test list >0
    @Test
    public void getListStudent_6() {

        ResponseEntity<Iterable<MemberHistoryDTO>> responseEntity
                = this.memberAccountController.getTradingHistory(0,"Mem-001","bat");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("2022-02-02", Objects.requireNonNull(responseEntity.getBody()).iterator().next().getTransactionalDate());
        Assertions.assertEquals("GD-0001", Objects.requireNonNull(responseEntity.getBody()).iterator().next().getCode());
        Assertions.assertEquals("S2", Objects.requireNonNull(responseEntity.getBody()).iterator().next().getScreenName());
        Assertions.assertEquals("Batman", Objects.requireNonNull(responseEntity.getBody()).iterator().next().getFilmName());
        Assertions.assertEquals("150000.0", Objects.requireNonNull(responseEntity.getBody()).iterator().next().getTicketPrice());
        Assertions.assertEquals("50000.0", Objects.requireNonNull(responseEntity.getBody()).iterator().next().getAttachedPrice());
        Assertions.assertEquals(2.2, Objects.requireNonNull(responseEntity.getBody()).iterator().next().getPoint());

    }

}

package C0921G1_sprint_1.controller;

import C0921G1_sprint_1.controller.member_management.MemberController;
import C0921G1_sprint_1.model.transaction.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberRestController_getGainedPointTransaction {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberController memberController;


    /**
     * Lấy lịch sử cộng điểm của người dùng khi có id null
     */
    @Test
    public void getListGainedPoint_id_1() {
        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory(null, "2022-05-05", "2022-05-07", 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }


    /**
     * Lấy lịch sử cộng điểm của người dùng khi có id rỗng
     */
    @Test
    public void getListGainedPoint_id_2() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("", "2022-05-05", "2022-05-07", 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * id không tồn tại trong DB
     */
    @Test
    public void getListGainedPoint_id_3() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("TV100", "2022-05-05", "2022-05-07", 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Lấy lịch sử cộng điểm của người dùng khi có ngày bắt đầu null
     */
    @Test
    public void getListGainedPoint_startDate_1() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("TV001", null, "2022-05-07", 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Lấy lịch sử cộng điểm của người dùng khi có ngày bắt đầu rỗng
     */
    @Test
    public void getListGainedPoint_startDate_2() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("TV001", "", "2022-05-07", 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Lấy lịch sử cộng điểm của người dùng khi có ngày kết thức null
     */
    @Test
    public void getListGainedPoint_endDate_1() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("TV001", "2022-05-05", null, 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Lấy lịch sử cộng điểm của người dùng khi có ngày kết thúc rỗng
     */
    @Test
    public void getListGainedPoint_endDate_2() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("TV001", "2022-05-05", "", 0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Lấy lịch sử cộng điểm của người dùng khi mọi thông tin đều đúng
     */
    @Test
    public void getListGainedPoint_4() {

        ResponseEntity<Page<Transaction>> responseEntity
                = this.memberController.viewGainedPointHistory("TV001", "2022-05-05", "2022-05-07", 0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}

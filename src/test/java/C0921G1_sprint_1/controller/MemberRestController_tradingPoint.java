package C0921G1_sprint_1.controller;

import C0921G1_sprint_1.controller.member_management.MemberController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberRestController_tradingPoint {
    @Autowired
    private MemberController memberController;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Đổi điểm của người dùng có id null
     */
    @Test
    public void tradingPoint_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/member/tradingPoint/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Đổi điểm của người dùng có id rỗng
     */
    @Test
    public void tradingPoint_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/member/tradingPoint/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Đổi điểm của người dùng có id không tồn tại trong DB
     */
    @Test
    public void tradingPoint_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/member/tradingPoint/{id}", "TV0011"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
package C0921G1_sprint_1.controller;


import C0921G1_sprint_1.dto.member.MemberDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberRestController_updateMember {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Nếu truyền vào một id null thì mong đợi ra lỗi đầu 4
     */
    @Test
    public void updateMember_19() throws Exception {
        MemberDTO testMemberDTO = new MemberDTO();
        testMemberDTO.setId(null);
        System.out.println(testMemberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Nếu truyền vào một id rỗng thì mong đợi ra lỗi đầu 4
     */
    @Test
    public void updateMember_20() throws Exception {
        MemberDTO testMemberDTO = new MemberDTO();
        testMemberDTO.setId("");
        System.out.println(testMemberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Nếu truyền vào một giá trị hợp lệ thì trả về 2xx OK
     */
    @Test
    public void updateMember_24() throws Exception {
        MemberDTO testMemberDTO = new MemberDTO();
        testMemberDTO.setId("TV002");

        testMemberDTO.setAddress("Hà Nội");
        testMemberDTO.setDateOfBirth("1999-08-02");
        testMemberDTO.setId("testmail@gmail.com");

        testMemberDTO.setIdentityNumber("011111111");
        testMemberDTO.setImage("testIMG");
        testMemberDTO.setName("Bành Thị Cô Hồn");
        testMemberDTO.setPhone("0909123569");


        System.out.println(testMemberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}

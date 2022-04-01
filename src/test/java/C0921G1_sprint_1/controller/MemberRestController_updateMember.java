package C0921G1_sprint_1.controller;


import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.security.Account;
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


    //lấy ra đối tượng dùng chung hết để mã nguồn không rối
    private static MemberDTO getMemberDTO(){
        MemberDTO testMemberDTO = new MemberDTO();
        testMemberDTO.setId("TV001");
        testMemberDTO.setAddress("Hà Nội");
        testMemberDTO.setDateOfBirth("1999-08-02");
        testMemberDTO.setEmail("testmail@gmail.com");
        testMemberDTO.setPoint(100.0);

        testMemberDTO.setIdentityNumber("011111111");
        testMemberDTO.setImage("testIMG");
        testMemberDTO.setName("Nguyễn Văn Hiếu");
        testMemberDTO.setPhone("0909123569");
        testMemberDTO.setGender(1);

        Account testAccount = new Account();
        testAccount.setId(1);
        testAccount.setEmail("mail1");
        testAccount.setEncryptPw("123456");
        testAccount.setEnabled(1);
        testAccount.setUsername("accoun00");

        testMemberDTO.setAccount(testAccount);

        City testCity = new City();
        testCity.setId(1);
        testCity.setName("Hà Nội");
        testCity.setSlug("HN");
        testCity.setType("Capital City");
        testMemberDTO.setCity(testCity);
        return testMemberDTO;
    };

    static MemberDTO testMemberDTO = getMemberDTO();

    /**
     * Nếu truyền vào một id null thì mong đợi ra lỗi đầu 4
     */
    @Test
    public void updateMember_19() throws Exception {
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
       testMemberDTO.setId("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Nếu truyền vào một giá trị name sai format thì trả về lỗi đầu 4
     */
    @Test
    public void updateMember_name_21() throws Exception {
        //người dùng không thao tác được với id nên set giống data base
        //tên sai
        testMemberDTO.setName("Nguyễn Văn Hiếu 123 ?@%^*U");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Nếu truyền vào một giá trị name bé hơn minlenght thì mong đợi lỗi đầu 4. minlenght = 1 nên tên rỗng
     */
    @Test
    public void updateMember_name_22() throws Exception {

        //tên rỗng
        testMemberDTO.setName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Nếu truyền vào một giá trị name lớn hơn maxlenght 50 ký tự thì mong đợi lỗi đầu 4.
     */
    @Test
    public void updateMember_name_23() throws Exception {
        //tên sai
        testMemberDTO.setName("Nguyễn Hosàng Hiếu Nghĩa Đệ Nhất Thương Tâm Thiện Nhân");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Nếu truyền vào một giá trị name bé hơn minlenght thì mong đợi lỗi đầu 4. minlenght = 1 nên tên rỗng
     */
    @Test
    public void updateMember_gender_22() throws Exception {

        //tên rỗng
        testMemberDTO.setName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Nếu truyền vào một giá trị name lớn hơn maxlenght 50 ký tự thì mong đợi lỗi đầu 4.
     */
    @Test
    public void updateMember_gender_23() throws Exception {
        //tên sai
        testMemberDTO.setName("Nguyễn Hoàng Hiếu Nghĩa Đệ Nhất Thương Tâm Thiện Nhân");
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

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/updateMember")
                        .content(this.objectMapper.writeValueAsString(testMemberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}

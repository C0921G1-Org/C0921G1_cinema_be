package C0921G1_sprint_1.member_management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Controller_InfoMember {

    @Autowired
    private MockMvc mockMvc;

    //test case with id = null - KhanhLDQ
    @Test
    public void getInfoMember_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/c09/admin/member-management/member-list/info/{id}}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test case with id = "" - KhanhLDQ
    @Test
    public void getInfoMember_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/c09/admin/member-management/member-list/info/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test case with id not existed in database - KhanhLDQ
    @Test
    public void getInfoMember_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/c09/admin/member-management/member-list/info/{id}", "abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test case with id existed in database - KhanhLDQ
    @Test
    public void getInfoMember_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/c09/admin/member-management/member-list/info/{id}", "Mem-010"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("Mem-010"))
                .andExpect(jsonPath("$.name").value("Nguyen F"))
                .andExpect(jsonPath("$.gender").value(0))
                .andExpect(jsonPath("$.phone").value("9012341234"))
                .andExpect(jsonPath("$.email").value("nguyenF@gmail.com"))
                .andExpect(jsonPath("$.address").value("Gia Lai"))
                .andExpect(jsonPath("$.point").value(2000))
                .andExpect(jsonPath("$.image").value(""))
                .andExpect(jsonPath("$.dateOfBirth").value("1995-09-02"))
                .andExpect(jsonPath("$.identityNumber").value("123999123"))
                .andExpect(jsonPath("$.city.id").value(5));
    }



}

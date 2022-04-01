package C0921G1_sprint_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class MemberRestController_viewDetailMember {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void viewDetail_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/getDetail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void viewDetail_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/getDetail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void viewDetail_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/getDetail/{id}", "134"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/getDetail/{id}", "TV001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("TV001"))
                .andExpect(jsonPath("$.name").value("Duong"))
                .andExpect(jsonPath("$.dateOfBirth").value("2022-02-02"));

    }

}

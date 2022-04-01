//package C0921G1_sprint_1.controller;
//
//import C0921G1_sprint_1.security.payload.request.LoginRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SecurityController_authenticateUser {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    //  Trường hợp username = null
//    @Test
//    public void authenticateUser_username_13() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("null");
//        loginRequest.setPassword("123456");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //  Trường hợp username rỗng
//    @Test
//    public void authenticateUser_username_14() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("");
//        loginRequest.setPassword("123456");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //  Trường hợp username sai với DB
//    @Test
//    public void authenticateUser_username() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("khactu");
//        loginRequest.setPassword("123456");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //  Trường hợp password = null
//    @Test
//    public void authenticateUser_password_13() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("user");
//        loginRequest.setPassword("null");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //  Trường hợp password rỗng
//    @Test
//    public void authenticateUser_password_14() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("user");
//        loginRequest.setPassword("");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //  Trường hợp password sai với DB
//    @Test
//    public void authenticateUser_password() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("user");
//        loginRequest.setPassword("123");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //  Trường hợp username vầ password đúng với DB, mong đợi kết quả trả về status 200, body chứa đối tượng JwtResponse
//    @Test
//    public void authenticateUser_password_18() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("admin");
//        loginRequest.setPassword("123456");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/c09/public/login")
//                        .content(this.objectMapper.writeValueAsString(loginRequest))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}

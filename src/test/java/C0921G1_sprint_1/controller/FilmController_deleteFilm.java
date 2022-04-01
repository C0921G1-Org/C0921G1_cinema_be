//package C0921G1_sprint_1.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class FilmController_deleteFilm {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    //trường hợp id null
//    @Test
//    public void deleteFilm_1() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/film/delete/{id}","null"))
//               .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //trường hợp id rỗng
//    @Test
//    public void deleteFilm_2() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/film/delete/{id}",""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //trường hợp id không có trong database
//    @Test
//    public void deleteFilm_3() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/film/delete/{id}","40"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //trường hợp id có trong database
//    @Test
//    public void deleteFilm_4() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/film/delete/{id}","3"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}

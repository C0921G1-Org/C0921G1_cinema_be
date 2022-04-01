 <<<<<<< special-ticket-TaiDHN
 package C0921G1_sprint_1.controller;
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
 public class FilmController_findByIdFilm {

     @Autowired
     private MockMvc mockMvc;


     //check trường hợp id null
     @Test
     public void findByIdFilm_1() throws Exception {
         this.mockMvc.perform(
                 MockMvcRequestBuilders
                         .get("/film/findById/{id}", "null"))
                 .andDo(print())
                 .andExpect(status().is4xxClientError());
     }


     //check trường hợp id rỗng
     @Test
     public void findByIdFilm_2() throws Exception {
         this.mockMvc.perform(
                 MockMvcRequestBuilders
                         .get("/film/findById/{id}", ""))
                 .andDo(print())
                 .andExpect(status().is4xxClientError());
     }

     //check trường hợp id không tồn tại
     @Test
     public void findByIdFilm_3() throws Exception {
         this.mockMvc.perform(
                 MockMvcRequestBuilders
                         .get("/film/findById/{id}", "22222"))
                 .andDo(print())
                 .andExpect(status().is4xxClientError());
     }

     //check trường hợp id đúng và trả về db
     @Test
     public void findByIdFilm_4() throws Exception {
         this.mockMvc.perform(
                         MockMvcRequestBuilders
                                 .get("/film/findById/{id}", "1"))
                 .andDo(print())
                 .andExpect(status().is2xxSuccessful())
                 .andExpect(jsonPath("$.id").value(1))
                 .andExpect(jsonPath("$.name").value("Bóng Đè"))
                 .andExpect(jsonPath("$.duration").value("101 phút"))
                 .andExpect(jsonPath("$.startDate").value("3/17/2022"))
                 .andExpect(jsonPath("$.endDate").value("3/30/2022"))
                 .andExpect(jsonPath("$.filmType.id").value(1))
                 .andExpect(jsonPath("$.actor").value("Quang Tuấn, Thanh Mỹ, Cát Vi, Diệu Nhi"))
                 .andExpect(jsonPath("$.director").value("Lê Văn Kiệt"))
                 .andExpect(jsonPath("$.studio").value("New Arena"))
                 .andExpect(jsonPath("$.image").value("https://www.galaxycine.vn/media/2022/2/18/300_1645169819244.jpg"))
                 .andExpect(jsonPath("$.trailer").value("https://youtu.be/Qm8iwrgXkqU"))
                 .andExpect(jsonPath("$.version").value("2d"))
                 .andExpect(jsonPath("$.flagDelete").value(0));
     }
 }





 =======
 //package C0921G1_sprint_1.controller;
 //import org.junit.jupiter.api.Test;
 //import org.springframework.beans.factory.annotation.Autowired;
 //import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 //import org.springframework.boot.test.context.SpringBootTest;
 //import org.springframework.test.web.servlet.MockMvc;
 //import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 //import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
 //import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 //import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 //
 //@SpringBootTest
 //@AutoConfigureMockMvc
 //public class FilmController_findByIdFilm {
 //
 //    @Autowired
 //    private MockMvc mockMvc;
 //
 //
 //    //check trường hợp id null
 //    @Test
 //    public void findByIdFilm_1() throws Exception {
 //        this.mockMvc.perform(
 //                MockMvcRequestBuilders
 //                        .get("/film/findById/{id}", "null"))
 //                .andDo(print())
 //                .andExpect(status().is4xxClientError());
 //    }
 //
 //
 //    //check trường hợp id rỗng
 //    @Test
 //    public void findByIdFilm_2() throws Exception {
 //        this.mockMvc.perform(
 //                MockMvcRequestBuilders
 //                        .get("/film/findById/{id}", ""))
 //                .andDo(print())
 //                .andExpect(status().is4xxClientError());
 //    }
 //
 //    //check trường hợp id không tồn tại
 //    @Test
 //    public void findByIdFilm_3() throws Exception {
 //        this.mockMvc.perform(
 //                MockMvcRequestBuilders
 //                        .get("/film/findById/{id}", "22222"))
 //                .andDo(print())
 //                .andExpect(status().is2xxSuccessful());
 //    }
 //
 //    //check trường hợp id đúng và trả về db
 //    @Test
 //    public void findByIdFilm_4() throws Exception {
 //        this.mockMvc.perform(
 //                        MockMvcRequestBuilders
 //                                .get("/film/findById/{id}", "1"))
 //                .andDo(print())
 //                .andExpect(status().is2xxSuccessful())
 //                .andExpect(jsonPath("$.id").value(1))
 //                .andExpect(jsonPath("$.name").value("Bóng Đè"))
 //                .andExpect(jsonPath("$.duration").value("101 phút"))
 //                .andExpect(jsonPath("$.startDate").value("3/17/2022"))
 //                .andExpect(jsonPath("$.endDate").value("3/30/2022"))
 //                .andExpect(jsonPath("$.filmType.id").value(1))
 //                .andExpect(jsonPath("$.actor").value("Quang Tuấn, Thanh Mỹ, Cát Vi, Diệu Nhi"))
 //                .andExpect(jsonPath("$.director").value("Lê Văn Kiệt"))
 //                .andExpect(jsonPath("$.studio").value("New Arena"))
 //                .andExpect(jsonPath("$.image").value("https://www.galaxycine.vn/media/2022/2/18/300_1645169819244.jpg"))
 //                .andExpect(jsonPath("$.trailer").value("https://youtu.be/Qm8iwrgXkqU"))
 //                .andExpect(jsonPath("$.version").value("2d"))
 //                .andExpect(jsonPath("$.flagDelete").value(0));
 //    }
 //}
 //
 //
 //
 //
 //
 >>>>>>> special_ticket_confirmation

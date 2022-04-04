//package C0921G1_sprint_1.controller;
//import C0921G1_sprint_1.dto.film.FilmDTO;
//import C0921G1_sprint_1.model.film.FilmType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
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
//public class Controller_CreateFilm {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    //test null --------------------------------------------------------------->
//
//    // duration null
//
//    @Test
//    public  void createFilm_13_duration_null() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//
//        filmDTO.setDuration(null);
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate("2022-03-04");
//  //      filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    // startDay null
//
//    @Test
//    public  void createFilm_13_startDay_null() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("60");
//        filmDTO.setStartDate(null);
//        filmDTO.setEndDate("2022-03-04");
// //       filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    // endDate null
//
//    @Test
//    public  void createFilm_13_endDay_null() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("60");
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate(null);
// //       filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//
//
//    // duration rong ---------------------------------------------------->
//
//    @Test
//    public  void createFilm_14_duration_rong() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("");
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate("2022-03-04");
//   //     filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    // startDay rong
//
//    @Test
//    public  void createFilm_14_startDay_rong() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("60p");
//        filmDTO.setStartDate("");
//        filmDTO.setEndDate("2022-03-04");
//     //   filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    // endDate rong
//
//    @Test
//    public  void createFilm_14_endDay_rong() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("60p");
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate("");
// //       filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//   // test sai format --------------------------------------------------------->
//    //format duration dơn vị là p nhưng nhập là 2h
//    @Test
//    public  void createFilm_15_duration_format() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("2h");
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate("2022-03-04");
//    //    filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    // format startDate >= ngày hiện tại và < endDate
//
//    @Test
//    public  void createFilm_15_startDay_format() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("60p");
//        filmDTO.setStartDate("2021-01-01");
//        filmDTO.setEndDate("2022-03-04");
//      //  filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    // format của EndtDate > startDate
//
//    @Test
//    public  void createFilm_15_endDay_format() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName("Funy Boy");
//        filmDTO.setDuration("60p");
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate("2021-01-01");
////        filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
////        filmDTO.setFlagDelete(0);
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    //test tat ca deu dung ------------------------------------------------------>
//
//    @Test
//    public  void createFilm_18() throws  Exception{
//        FilmDTO filmDTO = new FilmDTO();
//        filmDTO.setName(" Funy Boy");
//        filmDTO.setDuration("60p");
//        filmDTO.setStartDate("2022-03-01");
//        filmDTO.setEndDate("2022-03-04");
//     //   filmDTO.setTypeFilmNew("Hành Động");
//        filmDTO.setActor("Trấn Thành");
//        filmDTO.setDirector("Minh Ca");
//        filmDTO.setStudio("PC-03");
//        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
//        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
//        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);
<<<<<<< HEAD

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    // duration rong ---------------------------------------------------->

    @Test
    public  void createFilm_14_duration_rong() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("Funy Boy");
        filmDTO.setDuration("");
        filmDTO.setStartDate("2022-03-01");
        filmDTO.setEndDate("2022-03-04");
   //     filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // startDay rong

    @Test
    public  void createFilm_14_startDay_rong() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("Funy Boy");
        filmDTO.setDuration("60p");
        filmDTO.setStartDate("");
        filmDTO.setEndDate("2022-03-04");
     //   filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // endDate rong

    @Test
    public  void createFilm_14_endDay_rong() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("Funy Boy");
        filmDTO.setDuration("60p");
        filmDTO.setStartDate("2022-03-01");
        filmDTO.setEndDate("");
 //       filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


   // test sai format --------------------------------------------------------->
    //format duration dơn vị là p nhưng nhập là 2h
    @Test
    public  void createFilm_15_duration_format() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("Funy Boy");
        filmDTO.setDuration("2h");
        filmDTO.setStartDate("2022-03-01");
        filmDTO.setEndDate("2022-03-04");
    //    filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // format startDate >= ngày hiện tại và < endDate

    @Test
    public  void createFilm_15_startDay_format() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("Funy Boy");
        filmDTO.setDuration("60p");
        filmDTO.setStartDate("2021-01-01");
        filmDTO.setEndDate("2022-03-04");
      //  filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // format của EndtDate > startDate

    @Test
    public  void createFilm_15_endDay_format() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("Funy Boy");
        filmDTO.setDuration("60p");
        filmDTO.setStartDate("2022-03-01");
        filmDTO.setEndDate("2021-01-01");
//        filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
//        filmDTO.setFlagDelete(0);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    //test tat ca deu dung ------------------------------------------------------>

    @Test
    public  void createFilm_18() throws  Exception{
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName(" Funy Boy");
        filmDTO.setDuration("60p");
        filmDTO.setStartDate("2022-04-01");
        filmDTO.setEndDate("2022-04-04");
     //   filmDTO.setTypeFilmNew("Hành Động");
        filmDTO.setActor("Trấn Thành");
        filmDTO.setDirector("Minh Ca");
        filmDTO.setStudio("PC-03");
        filmDTO.setImage("https://firebasestorage.googleapis.com/v0/b/apiservice-edc10.appspot.com/o/28-03-2022023420AMhinh-nen-may-tinh-4k-game-min.jpg?alt=media&token=f73e55ae-b460-4143-b53d-6097a80468f6");
        filmDTO.setTrailer("https://www.youtube.com/watch?v=6F8tJgKz_v8");
        filmDTO.setVersion("3D");
        filmDTO.setFlagDelete(1);

        FilmType filmType = new FilmType();
        filmDTO.setId(5);
        filmDTO.setFilmType(filmType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(filmDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
=======
//
//        FilmType filmType = new FilmType();
//        filmDTO.setId(5);
//        filmDTO.setFilmType(filmType);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.post("/film/createFilm")
//                        .content(this.objectMapper.writeValueAsString(filmDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//}
>>>>>>> 985718e90a0bad7efc7882a150c97c5fc07ce1bb

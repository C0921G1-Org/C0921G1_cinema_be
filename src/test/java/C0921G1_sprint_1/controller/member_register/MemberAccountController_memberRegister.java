package C0921G1_sprint_1.controller.member_register;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.City;
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
public class MemberAccountController_memberRegister {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //NhanNT test thanh cong
    @Test
    public void createMember_18()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful());
    }

//    NhanNT test name null
    @Test
    public void createMember_name_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(null);
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
//    NhanNT test name " " - blank
    @Test
    public void createMember_name_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(" ");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
//    NhanNT test name format
    @Test
    public void createMember_name_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("dân gian");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
    //    NhanNT test gender null
    @Test
    public void createMember_gender_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(null);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
    }
    //    NhanNT test phone null
    @Test
    public void createMember_phone_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone(null);
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test phone ""-blank
    @Test
    public void createMember_phone_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test phone format
    @Test
    public void createMember_phone_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0005996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test email null
    @Test
    public void createMember_email_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail(null);
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test email ""-blank
    @Test
    public void createMember_email_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test email fortmat
    @Test
    public void createMember_email_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("asd");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test address null
    @Test
    public void createMember_address_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress(null);
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test address "" - blank
    @Test
    public void createMember_address_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test image null
    @Test
    public void createMember_image_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage(null);
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test image ""-blank
    @Test
    public void createMember_image_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test date of birth null
    @Test
    public void createMember_dateOfBirth_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth(null);
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test date of birth ""-blank
    @Test
    public void createMember_dateOfBirth_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test date of birth not format
    @Test
    public void createMember_dateOfBirth_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("20-02-2000");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test date of birth not 16 -100
    @Test
    public void createMember_dateOfBirth_16()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2007-02-02");
        memberDTO.setIdentityNumber("0905996846");

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test identityNumber null
    @Test
    public void createMember_identityNumber_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber(null);

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //    NhanNT test identityNumber ""-blank
    @Test
    public void createMember_identityNumber_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhone("0987654321");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setImage("testImg");
        memberDTO.setDateOfBirth("2000-02-02");
        memberDTO.setIdentityNumber(null);

        City city = new City();
        city.setId(1);
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

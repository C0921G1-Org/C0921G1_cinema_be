package C0921G1_sprint_1.member_management;

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
public class Controller_updateMember {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateMember_name_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        //blank name
        memberDTO.setName("");

        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenB@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_name_21() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        //format name
        memberDTO.setName("Le Van A123");

        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenB@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_name_22() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        //size name
        memberDTO.setName("Le A");

        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenB@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_phone_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);

        //blank phone
        memberDTO.setPhone("");

        memberDTO.setEmail("nguyenB@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_phone_21() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);

        //format phone
        memberDTO.setPhone("123456777");

        memberDTO.setEmail("nguyenB@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_email_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");

        //blank email
        memberDTO.setEmail("");

        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_email_21() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");

        //format email
        memberDTO.setEmail("nguyenA");

        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_address_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");

        //blank address
        memberDTO.setAddress("");

        memberDTO.setImage("");
        memberDTO.setDateOfBirth("2000-09-05");
        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_dateOfBirth_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");

        //blank dateOfBirth
        memberDTO.setDateOfBirth("");

        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_dateOfBirth_21() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");

        //check age member
        memberDTO.setDateOfBirth("2015-09-02");

        memberDTO.setIdentityNumber("123456123");
        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_identityNumber_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("1995-09-02");

        //blank identityNumber
        memberDTO.setIdentityNumber("");

        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_identityNumber_21() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Ha Noi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("1995-09-02");

        //format identityNumber
        memberDTO.setIdentityNumber("12345678");

        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateMember_24() throws Exception {
        MemberDTO memberDTO = new MemberDTO();

        City city = new City();
        city.setId(2);

        memberDTO.setName("Nguyen B Pro");
        memberDTO.setGender(0);
        memberDTO.setPhone("0901234567");
        memberDTO.setEmail("nguyenBPro@gmail.com");
        memberDTO.setAddress("Ha Noi Trong Toi");
        memberDTO.setImage("");
        memberDTO.setDateOfBirth("1995-09-02");
        memberDTO.setIdentityNumber("123456789");

        memberDTO.setCity(city);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/c09/admin/member-management/member-list/update/{id}", "Mem-002")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

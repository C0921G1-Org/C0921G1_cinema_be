package C0921G1_sprint_1.controller;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.showtime.ShowTimeDTO;

import C0921G1_sprint_1.model.transaction.Transaction;
import C0921G1_sprint_1.model.transaction.TransactionDto;

import C0921G1_sprint_1.service.special_ticket_confirmation.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
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
public class PaymentController_saveHistory {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PaymentService paymentService;


    // check code null
    @Test
    public void saveCode_code_13() throws Exception {


        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode(null);
        transactionDto.setTransactionalDate("2022-03-20");
        transactionDto.setTicketStatus("0");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // check transactionalDate null
    @Test
    public void saveCode_transactionalDate_13() throws Exception {


        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("BV-0001");
        transactionDto.setTransactionalDate(null);
        transactionDto.setTicketStatus("0");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // check ticketStatus null
    @Test
    public void saveCode_ticketStatus_13() throws Exception {


        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("BV-0001");
        transactionDto.setTransactionalDate("2022-03-20");
        transactionDto.setTicketStatus(null);

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // check code rỗng
    @Test
    public void saveCode_code_14() throws Exception {

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("");
        transactionDto.setTransactionalDate("2022-03-20");
        transactionDto.setTicketStatus("1");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // check TransactionalDate rỗng
    @Test
    public void saveCode_TransactionalDate_14() throws Exception {


        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("BV-0002");
        transactionDto.setTransactionalDate("");
        transactionDto.setTicketStatus("1");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // check setTicketStatus rỗng
    @Test
    public void saveCode_setTicketStatus_14() throws Exception {


        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("BV-0002");
        transactionDto.setTransactionalDate("2022-03-20");
        transactionDto.setTicketStatus("");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // check code sai format
    @Test
    public void saveCode_code_15() throws Exception {


        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("BD-001");
        transactionDto.setTransactionalDate("2022-03-20");
        transactionDto.setTicketStatus("1");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transactionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    // check dữ liệu đúng
    @Test
    public void saveCode_all_18() throws Exception {
        Transaction transaction = new Transaction();

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCode("BV-001");
        transactionDto.setTransactionalDate("2022-03-20");
        transactionDto.setTicketStatus("1");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId("2");
        transactionDto.setMemberDTO(memberDTO);

        ShowTimeDTO showTimeDTO = new ShowTimeDTO();
        showTimeDTO.setId(1);
        transactionDto.setShowTimeDTO(showTimeDTO);


        BeanUtils.copyProperties(transactionDto,transaction);
        paymentService.saveTransaction(transaction);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pay")
                        .content(this.objectMapper.writeValueAsString(transaction))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

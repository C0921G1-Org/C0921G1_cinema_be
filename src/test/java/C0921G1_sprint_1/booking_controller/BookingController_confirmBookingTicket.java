package C0921G1_sprint_1.booking_controller;

import C0921G1_sprint_1.controller.order_ticket.BookingController;
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
public class BookingController_confirmBookingTicket {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getConfirmTicket_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/BookingTicket/Confirm/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getConfirmTicket_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/BookingTicket/Confirm/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getConfirmTicket_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/BookingTicket/Confirm/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getConfirmTicket_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/BookingTicket/Confirm/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.code").value("BV0001"))
                .andExpect(jsonPath("$.ticketStatus").value("0"))
                .andExpect(jsonPath("$.transactionalDate").value("2022-03-25"))
                .andExpect(jsonPath("$.member.id").value("TV001"));
    }
}

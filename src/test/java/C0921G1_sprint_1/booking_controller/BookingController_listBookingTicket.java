package C0921G1_sprint_1.booking_controller;

import C0921G1_sprint_1.controller.order_ticket.BookingController;
import C0921G1_sprint_1.model.transaction.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class BookingController_listBookingTicket {

    @Autowired
    private BookingController bookingController;

//    Trường hợp trả về list có size = 0
    @Test
    public void getListBookingTicket_5() {
        ResponseEntity<Page<Transaction>> responseEntity
                = this.bookingController.getListTransaction(0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

//    Trường hợp trả về list có size > 0
    @Test
    public void getListBookingTicket_6() {
        ResponseEntity<Page<Transaction>> responseEntity
                = this.bookingController.getListTransaction(0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(23, responseEntity.getBody().getTotalElements());

        Assertions.assertEquals(22,
                responseEntity.getBody().getContent().get(9).getId());
        Assertions.assertEquals("BV0021",
                responseEntity.getBody().getContent().get(9).getCode());
        Assertions.assertEquals("TV022",
                responseEntity.getBody().getContent().get(9).getMember().getId());
        Assertions.assertEquals("Nguyễn Văn Thuận",
                responseEntity.getBody().getContent().get(9).getMember().getName());
        Assertions.assertEquals("04465651656",
                responseEntity.getBody().getContent().get(9).getMember().getIdentityNumber());
        Assertions.assertEquals("0945670289",
                responseEntity.getBody().getContent().get(9).getMember().getPhone());
        Assertions.assertEquals("2022-06-07",
                responseEntity.getBody().getContent().get(9).getTransactionalDate());
        Assertions.assertEquals("12:00",
                responseEntity.getBody().getContent().get(9).getShowTime().getName());
        Assertions.assertEquals("0",
                responseEntity.getBody().getContent().get(9).getTicketStatus());
    }
}

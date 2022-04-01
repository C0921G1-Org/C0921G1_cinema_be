package C0921G1_sprint_1.booking_controller;

import C0921G1_sprint_1.controller.order_ticket.BookingController;
import C0921G1_sprint_1.model.transaction.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class BookingController_searchListBookingTicket {

    @Autowired
    private BookingController bookingController;

    //Trường hợp tham số page null
    @Test
    public void getSearchBookingList_1_1(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"","","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số code null
    @Test
    public void getSearchBookingList_1_2(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0, 10),null,"","","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số name null
    @Test
    public void getSearchBookingList_1_3(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0, 10),"",null,"","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số member id null
    @Test
    public void getSearchBookingList_1_4(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0, 10),"","",null,"");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số phone null
    @Test
    public void getSearchBookingList_1_5(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0, 10),"","","",null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số tất cả null
    @Test
    public void getSearchBookingList_1_6(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,null,null,null,null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số code rỗng
    @Test
    public void getSearchBookingList_2_1(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"",null,null,null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số name rỗng
    @Test
    public void getSearchBookingList_2_2(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,null,"",null,null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số member id rỗng
    @Test
    public void getSearchBookingList_2_3(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,null,null,"",null);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số phone rỗng
    @Test
    public void getSearchBookingList_2_4(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,null,null,null,"");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp các tham số đều rỗng
    @Test
    public void getSearchBookingList_2_5(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"","","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số code không tồn tại trong DB
    @Test
    public void getSearchBookingList_3_1(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"ABCD","","","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số name không tồn tại trong DB
    @Test
    public void getSearchBookingList_3_2(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"","ABCD","","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số member id không tồn tại trong DB
    @Test
    public void getSearchBookingList_3_3(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"","","ABCD","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số phone không tồn tại trong DB
    @Test
    public void getSearchBookingList_3_4(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(null,"","","","ABCD");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số code tồn tại trong DB
    @Test
    public void getSearchBookingList_4_1(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0,10),"BV0008","","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số name tồn tại trong DB
    @Test
    public void getSearchBookingList_4_2(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0,10),"","Nguyễn Tuấn Bình","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số member id tồn tại trong DB
    @Test
    public void getSearchBookingList_4_3(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0,10),"","","TV009","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tham số phone tồn tại trong DB
    @Test
    public void getSearchBookingList_4_4(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0,10),"","","","0945612304");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Trường hợp tất cả tham số tồn tại trong DB
    @Test
    public void getSearchBookingList_4_5(){
        ResponseEntity<Page<Transaction>> responseEntity =
                this.bookingController.searchBookingTicket(PageRequest.of(0,10),"BV0008","Nguyễn Tuấn Bình","TV009","094567895461");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}

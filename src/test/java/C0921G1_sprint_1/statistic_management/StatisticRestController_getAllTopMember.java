package C0921G1_sprint_1.statistic_management;

import C0921G1_sprint_1.controller.statistic_management.StatisticController;
import C0921G1_sprint_1.dto.statistic.TopMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class StatisticRestController_getAllTopMember {
    @Autowired
    private StatisticController statisticController;

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số year = null
    @Test
    public void getAllTopMember_7_a() {
        ResponseEntity<List<TopMember>> responseEntity

                = this.statisticController.getAllTopMemberByQuarterAndYear(null, "2022");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số quarter = null
    @Test
    public void getAllTopMember_7_b() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("1", null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) cả 2 tham số truyền vào đều null
    @Test
    public void getAllTopMember_7_c() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear(null, null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year)
    // có tham số quarter = "" sẽ trả về list thống kê theo năm
    @Test
    public void getAllTopMember_8_a() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("", "2021");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().size());
        Assertions.assertEquals("TV001", responseEntity.getBody().get(0).getId());
        Assertions.assertEquals("ABC", responseEntity.getBody().get(0).getName());
        Assertions.assertEquals("3", responseEntity.getBody().get(0).getTotalTicket());
        Assertions.assertEquals("215000.0", responseEntity.getBody().get(0).getTotalMoney());
        Assertions.assertEquals("1000.0", responseEntity.getBody().get(0).getPoint());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year)
    // có tham số year = ""
    @Test
    public void getAllTopMember_8_b() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("1", "");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số
    // quarter = "" và year = "" sẽ trả về toàn bộ list
    @Test
    public void getAllTopMember_8_c() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().size());
        Assertions.assertEquals("TV001", responseEntity.getBody().get(1).getId());
        Assertions.assertEquals("ABC", responseEntity.getBody().get(1).getName());
        Assertions.assertEquals("3", responseEntity.getBody().get(1).getTotalTicket());
        Assertions.assertEquals("215000.0", responseEntity.getBody().get(1).getTotalMoney());
        Assertions.assertEquals("1000.0", responseEntity.getBody().get(1).getPoint());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số
    // quarter = 5 , không tồn tại quý 5 trong DB
    @Test
    public void getAllTopMember_9_a() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("5", "2022");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số
    // year = 2023 , không tồn tại năm 2023 trong DB
    @Test
    public void getAllTopMember_9_b() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("4", "2023");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số
    // quarter = 2 , year = 2022 ,xem thống kê quý 2 năm 2022 có tồn tại trong DB nhưng không có dữ liệu
    @Test
    public void getAllTopMember_10() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("2", "2022");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //Trường hợp getAllTopMemberByQuarterAndYear(quarter,year) có tham số
    //quarter = 1 , year = 2022 ,xem thống kê quý 1 năm 2022 có dữ liệu trả về
    @Test
    public void getAllTopMember_11() {
        ResponseEntity<List<TopMember>> responseEntity
                = this.statisticController.getAllTopMemberByQuarterAndYear("1", "2022");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().size());
        Assertions.assertEquals("TV002", responseEntity.getBody().get(0).getId());
        Assertions.assertEquals("ABC", responseEntity.getBody().get(0).getName());
        Assertions.assertEquals("1", responseEntity.getBody().get(0).getTotalTicket());
        Assertions.assertEquals("85000.0", responseEntity.getBody().get(0).getTotalMoney());
        Assertions.assertEquals("1000.0", responseEntity.getBody().get(0).getPoint());
    }
}

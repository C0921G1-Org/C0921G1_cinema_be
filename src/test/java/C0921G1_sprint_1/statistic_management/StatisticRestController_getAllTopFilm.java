package C0921G1_sprint_1.statistic_management;

import C0921G1_sprint_1.controller.statistic_management.StatisticController;
import C0921G1_sprint_1.dto.statistic.TopFilm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class StatisticRestController_getAllTopFilm {
    @Autowired
    private StatisticController statisticController;

    @Test
    public void getAllTopFilm_5() {
        ResponseEntity<List<TopFilm>> responseEntity
                = this.statisticController.getAllTopFilm();
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getAllTopFilm_6() {
        ResponseEntity<List<TopFilm>> responseEntity
                = this.statisticController.getAllTopFilm();
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().size());
        Assertions.assertEquals("Bóng Đè",
                responseEntity.getBody().get(1).getName());
        Assertions.assertEquals("3",
                responseEntity.getBody().get(1).getTotalTicket());
        Assertions.assertEquals("215000.0",
                responseEntity.getBody().get(1).getTotalMoney());
    }
}

//package C0921G1_sprint_1.controller;
//
//import C0921G1_sprint_1.controller.attached_service_management.AttachedServiceController;
//import C0921G1_sprint_1.model.attached_service.AttachedService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//@SpringBootTest
//public class AttachedServiceController_getAllAttachedServiceList {
//    @Autowired
//    private AttachedServiceController attachedServiceController;
//    /*Lấy dữ liệu có list size = 0 */
//    @Test
//    public void getAllAttachedServiceList_5(){
//        ResponseEntity<List<AttachedService>> responseEntity = this.attachedServiceController.getAllAttachedServiceList();
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    /*Lấy dữ liệu có list size > 0*/
//    @Test
//    public void getAllAttachedServiceList_6(){
//        ResponseEntity<List<AttachedService>> responseEntity = this.attachedServiceController.getAllAttachedServiceList();
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().get(1).getId());
//        Assertions.assertEquals("Combo 2", responseEntity.getBody().get(1).getName());
//        Assertions.assertEquals(110000, responseEntity.getBody().get(1).getPrice());
//        Assertions.assertEquals(2, responseEntity.getBody().get(1).getTransaction().getId());
//    }
//}
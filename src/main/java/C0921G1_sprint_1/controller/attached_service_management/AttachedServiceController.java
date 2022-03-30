package C0921G1_sprint_1.controller.attached_service_management;
import C0921G1_sprint_1.model.attached_service.AttachedService;
import C0921G1_sprint_1.service.attached_service.AttachedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/c09/user")
public class AttachedServiceController {
    @Autowired
    private AttachedServiceService attachedServiceService;

    /*DatTC - API lấy dữ liệu tất cả combo*/
    @GetMapping("/attachedService")
    public ResponseEntity<List<AttachedService>> getAllAttachedServiceList(){
        List<AttachedService> attachedServiceList = this.attachedServiceService.getAllAttachedServiceList();
        if (attachedServiceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(attachedServiceList, HttpStatus.OK);
        }
    }
}


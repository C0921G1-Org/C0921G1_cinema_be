package C0921G1_sprint_1.repository.attached_service_management;

import C0921G1_sprint_1.model.attached_service.AttachedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttachedServiceRepository extends JpaRepository<AttachedService, Integer> {
    /*DatTC - Query lấy dữ liệu combo*/
    @Query(value="SELECT * FROM attached_service", nativeQuery = true)
    List<AttachedService> getAllAttachedServiceList();

}

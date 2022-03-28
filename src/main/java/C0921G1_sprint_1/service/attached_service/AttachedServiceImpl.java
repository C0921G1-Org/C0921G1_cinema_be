package C0921G1_sprint_1.service.attached_service;

import C0921G1_sprint_1.model.attached_service.AttachedService;
import C0921G1_sprint_1.repository.attached_service_management.AttachedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachedServiceImpl implements AttachedServiceService {
    @Autowired
    private AttachedServiceRepository attachedServiceRepository;

    @Override
    public List<AttachedService> getAllAttachedServiceList() {
        return attachedServiceRepository.getAllAttachedServiceList();
    }
}

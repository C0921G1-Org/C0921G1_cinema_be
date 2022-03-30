package C0921G1_sprint_1.service.security.impl;

import C0921G1_sprint_1.model.security.Role;
import C0921G1_sprint_1.repository.security.RoleRepository;
import C0921G1_sprint_1.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAll() {
        return repository.getAll();
    }
}

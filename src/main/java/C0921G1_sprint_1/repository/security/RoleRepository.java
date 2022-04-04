package C0921G1_sprint_1.repository.security;

import C0921G1_sprint_1.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {


    /**
     * TuNK
     */
    @Query(value = "select * from role",nativeQuery = true)
    List<Role> getAll();

}

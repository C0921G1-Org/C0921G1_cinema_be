package C0921G1_sprint_1.repository.security;

import C0921G1_sprint_1.model.security.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {
}

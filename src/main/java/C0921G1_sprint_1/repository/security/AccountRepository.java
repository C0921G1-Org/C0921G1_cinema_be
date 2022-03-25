package C0921G1_sprint_1.repository.security;

import C0921G1_sprint_1.model.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * TuNK
     */
    @Query(value = "select * from account",nativeQuery = true)
    List<Account> getAll();

    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Account findByUsername(String username);
}

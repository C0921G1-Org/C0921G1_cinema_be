package C0921G1_sprint_1.service.security;

import C0921G1_sprint_1.model.security.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Account findAccountByUsername(String username);
}

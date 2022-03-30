package C0921G1_sprint_1.service.security.impl;

import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.repository.security.AccountRepository;
import C0921G1_sprint_1.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> getAll() {
        return repository.getAll();
    }

    @Override
    public Account findAccountByUsername(String username) {
        return repository.findAccountByUsername(username);
    }
}

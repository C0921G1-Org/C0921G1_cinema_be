package C0921G1_sprint_1.security.services;

import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.repository.security.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TuNk
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository repository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findAccountByUsername(username);
        if(account == null){
            throw new UsernameNotFoundException("User Not Found with username:"+ username);
        }
        return UserDetailsImpl.build(account);
    }
}

//package C0921G1_sprint_1.security.services;
//
//import C0921G1_sprint_1.model.security.Account;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * TuNK
// */
//public class UserDetailsImpl implements UserDetails {
//
//    private static final long serialVersionUID = 1L;
//    private Integer id;
//    private String username;
//    private Integer enabled;
//    @JsonIgnore
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//
//    public UserDetailsImpl(Integer id, String username, Integer enabled, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.enabled = enabled;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UserDetailsImpl build(Account account) {
//        List<GrantedAuthority>authorities = account.getAccountRoleSet().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRole().getName()))
//                .collect(Collectors.toList());
//
//        return new UserDetailsImpl(account.getId(), account.getUsername(), account.getIsEnabled(),
//                    account.getEncryptPw(), authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        if (enabled == 1){
//            return true;
//        }
//        return false;
//    }
//}

package C0921G1_sprint_1.controller.security;

import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.security.jwt.JwtTokenUtils;
import C0921G1_sprint_1.security.payload.request.LoginRequest;
import C0921G1_sprint_1.security.payload.response.JwtResponse;
import C0921G1_sprint_1.security.services.UserDetailsImpl;
import C0921G1_sprint_1.service.member_management.MemberService;
import C0921G1_sprint_1.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/c09/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;
    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser (@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =jwtTokenUtils.generateJwtToken(loginRequest.getUsername());

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Account account = accountService.findAccountByUsername(loginRequest.getUsername());
        Member member = memberService.findMemberById(account.getId().toString()).get();

        if (member != null) {
            member.setAccount(null);
        }

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles, member)
        );
    }
}

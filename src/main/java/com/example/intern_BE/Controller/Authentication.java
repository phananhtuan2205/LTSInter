package com.example.intern_BE.Controller;

import com.example.intern_BE.Entity.Account;
import com.example.intern_BE.Entity.User;
import com.example.intern_BE.Repo.AccountRepository;
import com.example.intern_BE.Security.CustomeUserDetailService;
import com.example.intern_BE.Security.CustomeUserDetails;
import com.example.intern_BE.Security.JwtTokkenProvider;
import com.example.intern_BE.Security.dto.LoginRequest;
import com.example.intern_BE.Security.dto.LoginResponse;
import com.example.intern_BE.Service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
@CrossOrigin(origins = "*")
public class Authentication {

    @Autowired
    private CustomeUserDetailService customeUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokkenProvider jwtTokkenProvider;

    @Autowired
    private UserInfo userInfo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        System.out.println("login username "+ loginRequest.getUsername());
        System.out.println("login password "+ loginRequest.getPassword());

        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );
        System.out.println(authentication.isAuthenticated());

        if (authentication.isAuthenticated()){
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setTokken( jwtTokkenProvider.generateToken(loginRequest.getUsername()));
            String username = jwtTokkenProvider.getUsernameFromJWT(loginResponse.getTokken());
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm.SSS");
            loginResponse.setExpiration(simpleDateFormat.format(jwtTokkenProvider.getDateFromJWT(loginResponse.getTokken())));
                if (getUserbyname(username)!=null&&getUserbyname(username).getAccount().getStatuses()!=0){
                    loginResponse.setRole(getUserbyname(username).getAccount().getDecentralization().getAuthorityName());
                    return loginResponse;
                }

        }

       return  null;
    }

    @GetMapping("/site/getUser")
    public User getUser(@RequestParam("tokken") String tokken){
        String username = jwtTokkenProvider.getUsernameFromJWT(tokken);
        User user = userInfo.getbyAccount(username);
        if (user==null){
            return null;
        }
        return user;

    }

    private User getUserbyname(String username) {
            User user = userInfo.getbyAccount(username);
            if (user==null){
                return null;
            }
            return user;
        }
}



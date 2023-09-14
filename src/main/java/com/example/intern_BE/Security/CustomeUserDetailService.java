package com.example.intern_BE.Security;


import com.example.intern_BE.Entity.User;
import com.example.intern_BE.Service.imp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailService implements UserDetailsService {
    @Autowired
    private UserImp userImp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userImp.getbyAccount(username);
        if (user == null){
            return null;
        }

        return new CustomeUserDetails(user);
    }
}

package com.example.intern_BE.Service.imp;

import com.example.intern_BE.Entity.User;
import com.example.intern_BE.Repo.UserRepository;
import com.example.intern_BE.Service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserImp implements UserInfo {
    @Autowired
    UserRepository userRepository;


    @Override
    public String create(User user) {

        if (user == null){
            return "không có user";
        }
        System.out.println(user.getEmail());
        boolean validateEmail = userRepository.findAll().stream().anyMatch(item->user.getEmail().equals(item.getEmail()));
        if (validateEmail){
            return "Email đã tồn tại";
        }
        LocalDateTime date = LocalDateTime.now();
        user.setCreatedAt(date);
        userRepository.save(user);
        return "Success";
    }

    @Override
    public List<User> getallname(Pageable pageable, String name) {
        Page<User> user = userRepository.findAll(pageable);
        List<User> list = new ArrayList<>();
        user.forEach(item->{
            if (item.getAccount().getStatuses() != 0 && item.getUserName().contains(name)){
                list.add(item);
            }
        });
        return list;
    }

    @Override
    public User getbyAccount(String username) {
        if (username == "" || username.isEmpty()){
            return null;
        }
        User user = userRepository.findAllByAccount_UserName(username);
        if (user == null){
            return null;
        }
        return user;
    }




}

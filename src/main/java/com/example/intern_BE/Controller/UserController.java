package com.example.intern_BE.Controller;

import com.example.intern_BE.Entity.User;
import com.example.intern_BE.Service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserInfo userInfo;

    @PostMapping("/site/User/create")
    public String create(@RequestBody User user){
        return userInfo.create(user);
    }

    @GetMapping("/site/Userbyaccount")
    public User show(@RequestParam("username") String name){
        return userInfo.getbyAccount(name);
    }
}

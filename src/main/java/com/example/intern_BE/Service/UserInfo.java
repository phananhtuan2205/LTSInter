package com.example.intern_BE.Service;

import com.example.intern_BE.Entity.Product;
import com.example.intern_BE.Entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserInfo {
    public String create(User user);
    public List<User> getallname(Pageable pageable, String name);
    public User getbyAccount (String username);

}

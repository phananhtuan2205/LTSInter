package com.example.intern_BE.Controller;

import com.example.intern_BE.Entity.Account;
import com.example.intern_BE.Service.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountInfo accountInfo;

    @PostMapping("/site/Account/create")
    public Account create(@RequestBody Account account){
        System.out.println(account.getUserName());
        Account account1 = accountInfo.addAccount(account);
        if (account1 != null){
            return account1;
        }
        return null;
    }

    @GetMapping("/site/Account/show")
    public List<Account> getall (@RequestParam("page") Optional<Integer> page, @RequestParam("username") String username, @RequestParam("size") Optional<Integer> size){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page.orElse(1)-1 , size.orElse(6),sort);

        return accountInfo.getall(pageable,username);
    }

    @DeleteMapping("/admin/Account/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Integer id){


        return new  ResponseEntity<>("Thanh cong", HttpStatus.OK);
    }
    @PutMapping("/site/Account/update")
    public ResponseEntity<Account> update(@RequestBody Account account){
        if (accountInfo.update(account)==null){
            return new  ResponseEntity<>(accountInfo.update(account), HttpStatus.valueOf(404));
        }

        return new  ResponseEntity<>(accountInfo.update(account), HttpStatus.OK);
    }
}

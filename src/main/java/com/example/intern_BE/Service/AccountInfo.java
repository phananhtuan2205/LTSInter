package com.example.intern_BE.Service;

import com.example.intern_BE.Entity.Account;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountInfo {
    public Account addAccount(Account account);
    public Account findAccountbyid (Integer id);
    public List<Account> getall(Pageable pageable,String username);
    public Account update(Account account);
    public void detele(Integer id);


}

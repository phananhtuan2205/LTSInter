package com.example.intern_BE.Service.imp;

import com.example.intern_BE.Entity.Account;
import com.example.intern_BE.Entity.Product;
import com.example.intern_BE.Repo.AccountRepository;
import com.example.intern_BE.Repo.DecentralizationRepository;
import com.example.intern_BE.Service.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountImp implements AccountInfo {


    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DecentralizationRepository decentralizationRepository;
    @Override
    public Account addAccount(Account account) {
        System.out.println("request is "+account.getUserName());
        boolean validateUserName = accountRepository.findAll().stream().anyMatch(item->account.getUserName().equals(item.getUserName()));
        System.out.println(validateUserName);
        if (validateUserName){
            return null;
        }

        else {
            try {
                if (account.getUserName() !="" && account.getPasswords() != ""){
                    LocalDateTime localDateTime = LocalDateTime.now();
                    account.setCreatedAt(localDateTime);
                    account.setStatuses(1);
                    if (account.getDecentralization() == null){
                        account.setDecentralization(decentralizationRepository.findById(2).get());
                    }
                    account.setPasswords(passwordEncoder.encode(account.getPasswords()));

                    return accountRepository.save(account);
                }
            }catch (Exception e){
                System.out.println(e);
            }
            return null;
        }

    }

    @Override
    public Account findAccountbyid(Integer id) {
        if (id == 0 || id == null){
            return null;
        }
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> getall(Pageable pageable, String username) {
        return accountRepository.findAll(pageable).stream().filter(item->item.getUserName().contains(username)).collect(Collectors.toList());
    }

    @Override
    public Account update(Account account) {
        boolean validateUserName = accountRepository.findAll().stream().anyMatch(item->account.getUserName().equals(item.getUserName()));
        System.out.println(validateUserName);
        if (validateUserName){
            return null;
        }

        else {
            if (account.getUserName() !="" && account.getPasswords() != ""){
                try {
                    Account account1 = accountRepository.findById(account.getId()).get();
                    account1.setUserName(account.getUserName());
                    account1.setPasswords(passwordEncoder.encode(account.getPasswords()));
                    LocalDateTime localDateTime = LocalDateTime.now();
                    account1.setUpdateAt(localDateTime);
                    account1.setStatuses(1);
                    if (account1.getDecentralization() == null){
                        account1.setDecentralization(decentralizationRepository.findById(2).get());
                    }


                    return accountRepository.save(account1);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            return null;
        }
    }

    @Override
    public void detele(Integer id) {
        if (id == 0 || id == null){
            return;
        }
        Account account = accountRepository.findById(id).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        account.setStatuses(0);
        account.setUpdateAt(localDateTime);
        accountRepository.save(account);
    }
}

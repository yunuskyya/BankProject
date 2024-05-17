package com.yunuskaya.banka.service;

import com.yunuskaya.banka.dto.CreateAccountRequest;
import com.yunuskaya.banka.model.Account;
import com.yunuskaya.banka.model.User;
import com.yunuskaya.banka.repository.AccountRepository;
import com.yunuskaya.banka.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;


    @Transactional
    public Account createAccount(CreateAccountRequest request, Long userId) {
        if (request.getBalance() == null) {
            request.setBalance(BigDecimal.ZERO);
        }
        // User validation and association with the account can be done here
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Account newAccount = new Account();
        newAccount.setUser(user);
        newAccount.setAccountNumber(request.getAccountNumber());
        newAccount.setAccountType(request.getAccountType());
        newAccount.setBalance(request.getBalance());
        return accountRepository.save(newAccount);
    }

    @Transactional
    public List<Account> getByUserId(Long userId) {
        return accountRepository.findByUser_Id(userId);
    }
}




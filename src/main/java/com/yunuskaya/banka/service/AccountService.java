package com.yunuskaya.banka.service;

import com.yunuskaya.banka.model.Account;
import com.yunuskaya.banka.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void depositToOwnAccount(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Hesap bulunamadı: " + accountId));

        // Hesaba belirtilen miktarı ekleyin
        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);

        // Hesabı kaydedin
        accountRepository.save(account);
    }
}


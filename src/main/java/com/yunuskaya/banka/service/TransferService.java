package com.yunuskaya.banka.service;
import com.yunuskaya.banka.model.Account;
import com.yunuskaya.banka.model.Transaction;
import com.yunuskaya.banka.repository.AccountRepository;
import com.yunuskaya.banka.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void transfer(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
        // Kaynak ve hedef hesapları bul
        Account sourceAccount = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new RuntimeException("Kaynak hesap bulunamadı: " + sourceAccountId));
        Account targetAccount = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new RuntimeException("Hedef hesap bulunamadı: " + targetAccountId));

        // Para transferi miktarını kontrol et
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Geçersiz transfer miktarı: " + amount);
        }

        // Kaynak hesapta yeterli bakiye var mı kontrol et
        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Yetersiz bakiye: " + sourceAccountId);
        }

        // Kaynak hesaptan para çekme
        BigDecimal newSourceBalance = sourceAccount.getBalance().subtract(amount);
        sourceAccount.setBalance(newSourceBalance);
        accountRepository.save(sourceAccount);

        // Hedef hesaba para ekleme
        BigDecimal newTargetBalance = targetAccount.getBalance().add(amount);
        targetAccount.setBalance(newTargetBalance);
        accountRepository.save(targetAccount);

        // Transfer işlemi kaydı oluştur
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);
    }
}


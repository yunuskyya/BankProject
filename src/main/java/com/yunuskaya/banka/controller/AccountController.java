package com.yunuskaya.banka.controller;

import com.yunuskaya.banka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/auth/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    public ResponseEntity<?> depositToOwnAccount(
            @RequestParam Long accountId,
            @RequestParam BigDecimal amount
    ) {
        try {
            accountService.depositToOwnAccount(accountId, amount);
            return ResponseEntity.ok("Para başarıyla hesaba yatırıldı.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Para yatırma işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }
}

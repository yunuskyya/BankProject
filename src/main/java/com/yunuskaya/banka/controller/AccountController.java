package com.yunuskaya.banka.controller;

import com.yunuskaya.banka.dto.CreateAccountRequest;

import com.yunuskaya.banka.model.Account;
import com.yunuskaya.banka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/auth/user/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request, @RequestParam Long userId) {
        try {
            accountService.createAccount(request, userId);
            return ResponseEntity.ok("Hesap başarıyla oluşturuldu.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Hesap oluşturma işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable Long userId) {
        List<Account> accounts = accountService.getByUserId(userId);
        return ResponseEntity.ok(accounts);
    }
}

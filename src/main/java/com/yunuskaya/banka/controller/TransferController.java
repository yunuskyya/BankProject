package com.yunuskaya.banka.controller;

import com.yunuskaya.banka.dto.TransferRequest;
import com.yunuskaya.banka.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/auth/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<?> transferMoney(
            @RequestParam Long sourceAccountId,
            @RequestParam Long targetAccountId,
            @RequestParam BigDecimal amount
    ) {
        try {
            transferService.transfer(sourceAccountId, targetAccountId, amount);
            return ResponseEntity.ok("Transfer işlemi başarılı.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Transfer işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }
}


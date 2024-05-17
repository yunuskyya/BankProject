package com.yunuskaya.banka.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private Long userId;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
}

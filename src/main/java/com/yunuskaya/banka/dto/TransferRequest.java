package com.yunuskaya.banka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TransferRequest {

    private Long sourceAccountId;
    private Long targetAccountId;
    private String description;
    private String amount;
    private LocalDate transactionDate;
}

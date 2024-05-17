package com.yunuskaya.banka.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue()
    private Long id;
    @ManyToOne
    private Account sourceAccount;
    @ManyToOne
    private Account targetAccount;
    private BigDecimal amount;
    private String description;
    private LocalDateTime transactionDate;


}

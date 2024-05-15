package com.yunuskaya.banka.repository;

import com.yunuskaya.banka.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

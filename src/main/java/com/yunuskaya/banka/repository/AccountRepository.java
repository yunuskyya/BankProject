package com.yunuskaya.banka.repository;

import com.yunuskaya.banka.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository  extends JpaRepository<Account, Long> {
    List<Account> findByUser_Id(Long userId);
}

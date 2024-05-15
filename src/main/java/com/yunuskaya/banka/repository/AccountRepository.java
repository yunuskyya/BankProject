package com.yunuskaya.banka.repository;

import com.yunuskaya.banka.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long> {
}

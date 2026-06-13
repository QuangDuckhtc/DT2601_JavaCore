package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    // Tìm kiếm tài khoản gần đúng theo Full Name
    List<Account> findByFullnameContaining(String keyword);
}

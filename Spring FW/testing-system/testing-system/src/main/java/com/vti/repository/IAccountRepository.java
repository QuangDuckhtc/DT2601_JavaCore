package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    // Tìm kiếm tài khoản gần đúng theo Full Name
    List<Account> findByFullnameContaining(String keyword);
}

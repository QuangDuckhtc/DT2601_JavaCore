package com.vti.service;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    List<Account> findByFullname(String name);
    Account findById(Integer id);
    Account create(Account account); // Truyền Object vào cho tiện thêm nhiều trường
    Account update(Integer id, Account account);
    boolean delete(Integer id);
}

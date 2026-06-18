package com.vti.service;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountUpdateForm;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> findAll(); // Thay đổi ở đây
    AccountDTO findById(Integer id); // Thay đổi ở đây
    List<Account> findByFullname(String name);

    Account create(Account account); // Truyền Object vào cho tiện thêm nhiều trường
    Account update(Integer id, Account account);
    boolean delete(Integer id);

// Dùng Account form
    void create(AccountCreateForm form);
    void update(Integer id, AccountUpdateForm form);
}

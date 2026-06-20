package com.vti.service;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountSearchForm;
import com.vti.form.AccountUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<AccountDTO> findAll(Pageable pageable, AccountSearchForm form);

    AccountDTO findById(Integer id);
    List<Account> findByFullname(String name);

    Account create(Account account);
    Account update(Integer id, Account account);
    boolean delete(Integer id);

// Dùng Account form
    void create(AccountCreateForm form);
    void update(Integer id, AccountUpdateForm form);
}

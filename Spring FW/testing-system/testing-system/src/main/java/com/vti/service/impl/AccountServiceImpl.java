package com.vti.service.impl;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findByFullname(String name) {
        return accountRepository.findByFullnameContaining(name);
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account create(Account account) {
        //  .set của Lombok
        Account newAcc = new Account(
                null,
                account.getEmail(),
                account.getUsername(),
                account.getFullname(),
                account.getDepartmentId(),
                account.getPositionId(),
                null
        );
        return accountRepository.save(newAcc);
    }

    @Override
    public Account update(Integer id, Account account) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent()) {
            Account existingAcc = optional.get();
            Account updatedAcc = new Account(
                    id,
                    account.getEmail(),
                    account.getUsername(),
                    account.getFullname(),
                    account.getDepartmentId(),
                    account.getPositionId(),
                    existingAcc.getCreateDate() // Giữ nguyên ngày tạo cũ
            );
            return accountRepository.save(updatedAcc);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.vti.service.impl;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findByFullname(String search) {
        return accountRepository.findByFullnameContaining(search);
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account create(Account account) {
        // Kiểm tra và kết nối với  Department thực tế từ DB
        if (account.getDepartment() != null && account.getDepartment().getDepartmentId() != null) {
            Department dept = departmentRepository.findById(account.getDepartment().getDepartmentId()).orElse(null);
            account.setDepartment(dept);
        }

        // Kiểm tra và kết nối với Position thực tế từ DB
        if (account.getPosition() != null && account.getPosition().getPositionId() != null) {
            Position pos = positionRepository.findById(account.getPosition().getPositionId()).orElse(null);
            account.setPosition(pos);
        }

        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);

            if (account.getDepartment() != null && account.getDepartment().getDepartmentId() != null) {
                Department dept = departmentRepository.findById(account.getDepartment().getDepartmentId()).orElse(null);
                account.setDepartment(dept);
            }
            if (account.getPosition() != null && account.getPosition().getPositionId() != null) {
                Position pos = positionRepository.findById(account.getPosition().getPositionId()).orElse(null);
                account.setPosition(pos);
            }

            return accountRepository.save(account);
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
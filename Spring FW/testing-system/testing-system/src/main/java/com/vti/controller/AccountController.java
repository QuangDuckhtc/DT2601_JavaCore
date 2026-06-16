package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    // Lấy tất cả hoặc tìm kiếm theo fullname
    @GetMapping
    public ResponseEntity<List<Account>> findAll(@RequestParam(value = "search", required = false) String search) {
        List<Account> accounts;
        if (search != null && !search.isEmpty()) {
            accounts = accountService.findByFullname(search);
        } else {
            accounts = accountService.findAll();
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Lấy theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Integer id) {
        Account account = accountService.findById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        Account createdAcc = accountService.create(account);
        return new ResponseEntity<>(createdAcc, HttpStatus.CREATED);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Integer id, @RequestBody Account account) {
        Account updatedAcc = accountService.update(id, account);
        if (updatedAcc != null) {
            return new ResponseEntity<>(updatedAcc, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (accountService.delete(id)) {
            return new ResponseEntity<>("Xóa thành công !", HttpStatus.OK);
        }
        return new ResponseEntity<>("ID không tồn tại !", HttpStatus.NOT_FOUND);
    }
}
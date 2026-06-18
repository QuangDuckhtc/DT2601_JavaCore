package com.vti.controller;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountUpdateForm;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    // Lấy tất cả hoặc tìm kiếm theo fullname
    // 1. Lấy toàn bộ danh sách và ép sang List DTO bằng Constructor mới
    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll() {
        // 1. Lấy thẳng danh sách DTO từ service về
        List<AccountDTO> dtos = accountService.findAll();

        // 2. Trả thẳng về luôn, không cần .stream().map(...) gì nữa hết!
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    // 2. Lấy chi tiết 1 Account theo ID và ép sang DTO bằng Constructor mới
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Integer id) {
        // 1. Hứng thẳng bằng kiểu dữ liệu AccountDTO từ Service trả về
        AccountDTO dto = accountService.findById(id);

        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Thêm mới
//    @PostMapping
//    public ResponseEntity<Account> create(@RequestBody Account account) {
//        Account createdAcc = accountService.create(account);
//        return new ResponseEntity<>(createdAcc, HttpStatus.CREATED);
//    }

//    // Cập nhật
//    @PutMapping("/{id}")
//    public ResponseEntity<Account> update(@PathVariable Integer id, @RequestBody Account account) {
//        Account updatedAcc = accountService.update(id, account);
//        if (updatedAcc != null) {
//            return new ResponseEntity<>(updatedAcc, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    // Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            accountService.delete(id);
            return new ResponseEntity<>("Delete account successfully", HttpStatus.OK);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {

            return new ResponseEntity<>("Không thể xóa tài khoản này vì họ đang là người tạo (Creator) của một số Group!", HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping // dùng cho tính năng THÊM MỚI
    public ResponseEntity<?> create(@RequestBody AccountCreateForm form) {
        try {

            accountService.create(form);

            return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);

        } catch (RuntimeException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody AccountUpdateForm form) {
        try {

            accountService.update(id, form);

            // 200 OK
            return new ResponseEntity<>("Update successfully", HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
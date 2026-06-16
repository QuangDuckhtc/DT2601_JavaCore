package com.vti.controller;

import com.vti.entity.GroupAccount;
import com.vti.service.IGroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-accounts")
public class GroupAccountController {

    @Autowired
    private IGroupAccountService groupAccountService;

    // 1. Lấy tất cả danh sách thành viên tham gia các nhóm (GET)
    @GetMapping
    public ResponseEntity<List<GroupAccount>> findAll() {
        List<GroupAccount> list = groupAccountService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 2. Thêm một nhân viên vào một nhóm (POST)
    @PostMapping
    public ResponseEntity<GroupAccount> create(@RequestBody GroupAccount groupAccount) {
        GroupAccount created = groupAccountService.create(groupAccount);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // 3. Xóa một nhân viên ra khỏi nhóm dựa vào cặp ID (DELETE)
    // DELETE http://localhost:8080/api/group-accounts?groupId=1&accountId=2
    @DeleteMapping
    public ResponseEntity<String> delete(
            @RequestParam Integer groupId,
            @RequestParam Integer accountId) {

        if (groupAccountService.delete(groupId, accountId)) {
            return new ResponseEntity<>("Xóa thành viên khỏi nhóm thành công!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy thành viên này trong nhóm!", HttpStatus.NOT_FOUND);
    }
}
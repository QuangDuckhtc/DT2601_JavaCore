package com.vti.controller;

import com.vti.entity.Group;
import com.vti.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> findAll() {
        return new ResponseEntity<>(groupService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> findById(@PathVariable Integer id) {
        Group group = groupService.findById(id);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Group> create(@RequestBody Group group) {
        Group createdGroup = groupService.create(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (groupService.delete(id)) {
            return new ResponseEntity<>("Xóa thành công !", HttpStatus.OK);
        }
        return new ResponseEntity<>("ID không tồn tại ", HttpStatus.NOT_FOUND);
    }
}

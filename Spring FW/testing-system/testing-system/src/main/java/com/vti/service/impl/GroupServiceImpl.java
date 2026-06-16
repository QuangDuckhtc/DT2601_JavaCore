package com.vti.service.impl;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IGroupRepository;
import com.vti.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Group create(Group group) {
        // Kiểm tra xem người tạo (creator) có tồn tại thực tế dưới bảng Account không
        if (group.getCreator() != null && group.getCreator().getId() != null) {
            Account creator = accountRepository.findById(group.getCreator().getId()).orElse(null);
            group.setCreator(creator);
        }
        return groupRepository.save(group);
    }

    @Override
    public boolean delete(Integer id) {
        if (groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

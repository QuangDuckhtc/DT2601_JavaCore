package com.vti.service.impl;

import com.vti.entity.GroupAccount;
import com.vti.entity.GroupAccountId;
import com.vti.repository.IGroupAccountRepository;
import com.vti.service.IGroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupAccountServiceImpl implements IGroupAccountService {

    @Autowired
    private IGroupAccountRepository groupAccountRepository;

    @Override
    public List<GroupAccount> findAll() {
        return groupAccountRepository.findAll();
    }

    @Override
    public GroupAccount create(GroupAccount groupAccount) {

        if (groupAccount.getJoinDate() == null) {
            groupAccount.setJoinDate(new Date());
        }
        return groupAccountRepository.save(groupAccount);
    }

    @Override
    public boolean delete(Integer groupId, Integer accountId) {

        GroupAccountId id = new GroupAccountId(groupId, accountId);


        if (groupAccountRepository.existsById(id)) {
            groupAccountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.vti.service;

import com.vti.entity.GroupAccount;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IGroupAccountService {
    List<GroupAccount> findAll();

    GroupAccount create(GroupAccount groupAccount);

    boolean delete(Integer groupId, Integer accountId);
}

package com.vti.service;

import com.vti.entity.Group;

import java.util.List;

public interface IGroupService {
    List<Group> findAll();
    Group findById(Integer id);
    Group create(Group group);
    boolean delete(Integer id);
}

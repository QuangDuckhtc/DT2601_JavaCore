package com.vti.repository;

import com.vti.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findByCreator_Id(Integer accountId);
}

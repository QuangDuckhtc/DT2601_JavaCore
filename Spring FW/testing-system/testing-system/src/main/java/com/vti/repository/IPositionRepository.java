package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.enumerate.PositionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer>, JpaSpecificationExecutor<Position> {
    Optional<Position> findByPositionName(PositionName positionName);

}

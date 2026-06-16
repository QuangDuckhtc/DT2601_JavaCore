package com.vti.entity;

import com.vti.enumerate.PositionName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "position")
@Data //
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name", nullable = false)
    private PositionName positionName;

    @OneToMany(mappedBy = "position")
    @ToString.Exclude
    private List<Account> accounts;
}

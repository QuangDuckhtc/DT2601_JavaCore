package com.vti.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`account`") // Dùng dấu ` vì account là từ khóa trùng với MySQL
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "user_name", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "full_name", nullable = false, unique = true, length = 100)
    private String fullname;

    @Column(name = "department_id")
    private Integer departmentId; // bỏ qua khóa ngoại

    @Column(name = "position_id")
    private Integer positionId;   //  bỏ qua khóa ngoại

    @Column(name = "create_date", insertable = false, updatable = false)
    private LocalDateTime createDate;
}
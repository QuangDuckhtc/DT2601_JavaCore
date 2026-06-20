package com.vti.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`account`") // Dùng dấu ` vì account là từ khóa trùng với MySQL
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "user_name", length = 100, nullable = false, unique = true)
    private String username;

    // THÊM DÒNG NÀY THEO CHUẨN JPA SPRING BOOT:
    @Column(name = "password", length = 80, nullable = false)
    private String password;

    @Column(name = "full_name", length = 100, nullable = false, unique = true)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "creator")
    @ToString.Exclude
    private List<Group> createdGroups;

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    private List<GroupAccount> groupAccounts;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", insertable = false, updatable = false)
    private Date createDate;
}
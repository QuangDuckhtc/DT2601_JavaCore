package com.vti.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter // Tự sinh các hàm lấy dữ liệu (getId, getName)
@Setter // Tự sinh các hàm gán dữ liệu (setId, setName)
@NoArgsConstructor // Constructor không tham số
@AllArgsConstructor // Constructor đầy đủ tham số
@Entity // Khai báo thực thể JPA
@Table(name = "department") // Ánh xạ bảng database
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name", length = 100, nullable = false, unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Account> accounts;
}
package com.vti.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Tự sinh các hàm lấy dữ liệu (getId, getName)
@Setter // Tự sinh các hàm gán dữ liệu (setId, setName)
@NoArgsConstructor // Constructor không tham số
@AllArgsConstructor // Constructor đầy đủ tham số
@Entity // Khai báo thực thể JPA
@Table(name = "department") // Ánh xạ bảng database
public class Department {

    @Id // Khóa chính
    @Column(name = "department_id") // Khớp cột database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng
    private Integer id;

    @Column(name = "department_name", nullable = false, unique = true, length = 100) // Cấu hình cột name
    private String name;
}
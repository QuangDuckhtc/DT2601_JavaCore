package com.vti.service;

import com.vti.DTO.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentSearchForm;
import com.vti.form.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    // findALL theo DTO
    Page<DepartmentDTO> findAll(Pageable pageable, DepartmentSearchForm form);            // Lấy tất cả

    List<Department> findByName(String name);    // Tìm theo tên

    DepartmentDTO findById(Integer id);            // Tìm theo ID

    Department create(String name);             // Thêm mới (Truyền String name)

    Department update(Integer id, String newName); // Cập nhật (Truyền String newName)

    boolean delete(Integer id);

    // create + update theo form

    void create(DepartmentCreateForm form);

    void update(Integer id, DepartmentUpdateForm form);
}
package com.vti.service.impl;

import com.vti.DTO.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentSearchForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.repository.IDepartmentRepository;
import com.vti.service.IDepartmentService;
import com.vti.specification.DepartmentCustomSpecification;
import io.micrometer.common.util.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    // dùng DTO
    @Override
    public Page<DepartmentDTO> findAll(Pageable pageable, DepartmentSearchForm form) {
        Specification<Department> where = Specification.unrestricted();// where 1 = 1


        if (StringUtils.isNotEmpty(form.getName())) {
            DepartmentCustomSpecification nameSpec = new DepartmentCustomSpecification("departmentName", form.getName());
            where = where.and(nameSpec);
        }
        Page<Department> pageDep = departmentRepository.findAll(where, pageable);
        return pageDep.map(dep -> modelMapper.map(dep, DepartmentDTO.class));
    }

    @Override
    public List<Department> findByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

    // dùng DTO
    @Override
    public DepartmentDTO findById(Integer id) {
        // 1. Tìm Entity dưới DB
        Department department = departmentRepository.findById(id).orElse(null);
        if (department == null) {
            return null;
        }

        // 2. Map sang DTO và trả về
        return modelMapper.map(department, DepartmentDTO.class);
    }

    @Override
    public Department create(String name) {
        // Tự tạo Object Department mới rồi gán name vào để lưu xuống DB
        Department department = new Department();
        department.setDepartmentName(name);
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Integer id, String newName) {
        // Kiểm tra xem phòng ban cần sửa có tồn tại không
        if (departmentRepository.existsById(id)) {
            Department department = new Department();
            department.setDepartmentId(id);       // Giữ nguyên ID cũ
            department.setDepartmentName(newName); // Cập nhật tên mới
            return departmentRepository.save(department);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void create(DepartmentCreateForm form) {
        Department department = new Department();

        // Bốc name từ trong Form ra để set vào Entity
        department.setDepartmentName(form.getName());

        departmentRepository.save(department);
    }

    @Override
    public void update(Integer id, DepartmentUpdateForm form) {

        Department department = departmentRepository.findById(id).orElse(null);
        if (Objects.isNull(department)) {
            throw new RuntimeException("Department ID not found!");
        }

        department.setDepartmentName(form.getName());

        departmentRepository.save(department);
    }
}
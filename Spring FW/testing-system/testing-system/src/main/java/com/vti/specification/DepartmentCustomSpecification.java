package com.vti.specification;

import com.vti.entity.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentCustomSpecification implements Specification<Department> {
    private String field;
    private Object value;

    public DepartmentCustomSpecification(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (value == null) {
            return null;
        }

        return cb.like(root.get(field).as(String.class), "%" + value.toString() + "%");
    }
}

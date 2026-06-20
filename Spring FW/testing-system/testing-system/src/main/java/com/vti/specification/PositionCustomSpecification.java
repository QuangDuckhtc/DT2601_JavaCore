package com.vti.specification;

import com.vti.entity.Position;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class PositionCustomSpecification implements Specification<Position> {
    private String field;
    private Object value;

    public PositionCustomSpecification(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Position> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (value == null) return null;
        return cb.like(root.get(field).as(String.class), "%" + value.toString() + "%");
    }
}

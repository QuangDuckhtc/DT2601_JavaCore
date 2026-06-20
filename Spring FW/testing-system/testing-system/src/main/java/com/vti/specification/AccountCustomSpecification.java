package com.vti.specification;

import com.vti.entity.Account;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class AccountCustomSpecification implements Specification<Account> {
    @NonNull
    private String field;
    @NonNull
    private Object value;
    @Override
    public Predicate toPredicate(Root<Account> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {


        System.out.println("DEBUG: Object hash: " + this.hashCode() + " | Field nhận được: '" + this.field + "' | Value nhận được: '" + this.value + "'");

        if (value == null || value.toString().isEmpty()) return null;
        //criteriaBuilder : tajo ra cau SQL
        if("username".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
        }
        if("fullName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("fullName"), "%" + value.toString() + "%");
        }
        if("email".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("email"), "%" + value.toString() + "%");
        }
        if("departmentName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("department").get("departmentName"), "%" + value.toString()+ "%");
        }
        if("positionName".equalsIgnoreCase(field)){
            return criteriaBuilder.like(root.get("position").get("positionName"), "%" + value.toString() + "%");
        }
        return  null;
    }
}

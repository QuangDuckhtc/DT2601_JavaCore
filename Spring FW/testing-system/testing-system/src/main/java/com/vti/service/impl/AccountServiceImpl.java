package com.vti.service.impl;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountSearchForm;
import com.vti.form.AccountUpdateForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IGroupRepository;
import com.vti.repository.IPositionRepository;
import com.vti.service.IAccountService;
import com.vti.specification.AccountCustomSpecification;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IGroupRepository groupRepository;

    @Override
    public Page<AccountDTO> findAll(Pageable pageable, AccountSearchForm form) {
        // 1. Khởi tạo Specification bắt đầu từ null hoặc điều kiện mặc định
        Specification<Account> where = Specification.unrestricted();// where 1 = 1

        // 2. Sử dụng Specification.where() để khởi tạo
        if (StringUtils.isNotEmpty(form.getUserName())) {
            AccountCustomSpecification usernameSpec = new AccountCustomSpecification("username", form.getUserName());
            where = where.and(usernameSpec);
        }
        if (StringUtils.isNotEmpty(form.getEmail())) {
            AccountCustomSpecification emailSpec = new AccountCustomSpecification("email", form.getEmail());
            where =  where.and(emailSpec);
        }
        if (StringUtils.isNotEmpty(form.getFullName())) {
            AccountCustomSpecification fullNameSpec = new AccountCustomSpecification("fullName", form.getFullName());
            where = where.and(fullNameSpec);
        }
        if (StringUtils.isNotEmpty(form.getDepartmentName())) {
            AccountCustomSpecification departmentNameSpec = new AccountCustomSpecification("departmentName", form.getDepartmentName());
            where =  where.and(departmentNameSpec);
        }
        if (StringUtils.isNotEmpty(form.getPositionName())) {
            AccountCustomSpecification posittionNameSpec = new AccountCustomSpecification("positionName", form.getPositionName());
            where = where.and(posittionNameSpec);
        }
        Page <Account> pageAcc = accountRepository.findAll(where, pageable);
//
//        for (Account acc : accounts) {
//            AccountDTO dto = modelMapper.map(acc, AccountDTO.class);
//            dtoList.add(dto);
//        }
//
//        return dtoList;

//        return accounts.stream()
//                .map(acc -> modelMapper.map(acc, AccountDTO.class))
//                .collect(Collectors.toList());
        Page<AccountDTO> pageDTO = pageAcc.map(account -> modelMapper.map(account, AccountDTO.class));
        return pageDTO;
    }
    @Override
    public List<Account> findByFullname(String search) {

        return accountRepository.findByFullNameContaining(search);
    }


    @Override
    public AccountDTO findById(Integer id) {
        // 1. Tìm account từ database
        Account account = accountRepository.findById(id).orElse(null);


        if (Objects.isNull(account)) {
            throw new RuntimeException("ID not found");
        }
        AccountDTO dto = modelMapper.map(account, AccountDTO.class);
        return dto;
    }

    @Override
    public Account create(Account account) {
        // Kiểm tra và kết nối với  Department thực tế từ DB
        if (account.getDepartment() != null && account.getDepartment().getDepartmentId() != null) {
            Department dept = departmentRepository.findById(account.getDepartment().getDepartmentId()).orElse(null);
            account.setDepartment(dept);
        }

        // Kiểm tra và kết nối với Position thực tế từ DB
        if (account.getPosition() != null && account.getPosition().getPositionId() != null) {
            Position pos = positionRepository.findById(account.getPosition().getPositionId()).orElse(null);
            account.setPosition(pos);
        }

        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);

            if (account.getDepartment() != null && account.getDepartment().getDepartmentId() != null) {
                Department dept = departmentRepository.findById(account.getDepartment().getDepartmentId()).orElse(null);
                account.setDepartment(dept);
            }
            if (account.getPosition() != null && account.getPosition().getPositionId() != null) {
                Position pos = positionRepository.findById(account.getPosition().getPositionId()).orElse(null);
                account.setPosition(pos);
            }

            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        // 1. Kiểm tra xem tài khoản có tồn tại không
        if (!accountRepository.existsById(id)) {
            throw new RuntimeException("Account ID không tồn tại!");
        }

        List<Group> groups = groupRepository.findByCreator_Id(id);
        for (Group group : groups) {
            group.setCreator(null); // Gỡ bỏ ông bố ra
            groupRepository.save(group); // Cập nhật lại dưới DB
        }

        accountRepository.deleteById(id);

        return true;
    }


    // CREATE + UPDATE THEO FORM
    @Override
    public void create(AccountCreateForm form) {
        // Tạo mới một đối tượng Entity để chuẩn bị lưu vào DB
        Account account = new Account();
        account.setUsername(form.getUsername());
        account.setFullName(form.getFullName());
        account.setEmail(form.getEmail());


        account.setPassword(form.getPassword());

        // 1. Chuyển departmentId ở form -> department
        Department department = departmentRepository.findById(form.getDepartmentId()).orElse(null);
        if (Objects.isNull(department)) {
            throw new RuntimeException("Department ID not found!");
        }
        account.setDepartment(department);

        // 2. Chuyển positionId ở form -> position
        Position position = positionRepository.findById(form.getPositionId()).orElse(null);
        if (Objects.isNull(position)) {
            throw new RuntimeException("Position ID not found!");
        }
        account.setPosition(position);

        // 3. Lưu vào Database
        accountRepository.save(account);
    }

    @Override
    public void update(Integer id, AccountUpdateForm form) {
        // 1. Tìm xem Account cần sửa có tồn tại dưới DB không
        Account account = accountRepository.findById(id).orElse(null);
        if (Objects.isNull(account)) {
            throw new RuntimeException("Account ID not found!");
        }
        if (accountRepository.existsByEmailAndIdNot(form.getEmail(), id)) {
            throw new RuntimeException("Email exist !");
        }

        // 2. Lấy thông tin từ Form đè vào Entity gốc
        account.setFullName(form.getFullName());
        account.setEmail(form.getEmail());

        // 3. Chuyển đổi departmentId ở form -> department dưới DB
        Department department = departmentRepository.findById(form.getDepartmentId()).orElse(null);
        if (Objects.isNull(department)) {
            throw new RuntimeException("Department ID not found!");
        }
        account.setDepartment(department);

        // 4. Chuyển đổi positionId ở form -> position
        Position position = positionRepository.findById(form.getPositionId()).orElse(null);
        if (Objects.isNull(position)) {
            throw new RuntimeException("Position ID not found!");
        }
        account.setPosition(position);

        //  lưu đè xuống Database
        accountRepository.save(account);
    }
}
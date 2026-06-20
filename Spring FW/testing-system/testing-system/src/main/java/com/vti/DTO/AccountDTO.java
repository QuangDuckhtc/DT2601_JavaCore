package com.vti.DTO;

import com.vti.entity.Account;

public class AccountDTO {
    // bỏ password đi

    private String userName;
    private String fullName;
    private String email;
    private String departmentName;
    private String positionName;
    private String createDate;


    public AccountDTO() {
    }


    public AccountDTO(Account account) {
        if (account != null) {
            this.userName = account.getUsername();
            this.fullName = account.getFullName();
            this.email = account.getEmail();

            //  Kiểm tra null trước khi ép kiểu Date sang String
            this.createDate = account.getCreateDate() != null ? String.valueOf(account.getCreateDate()) : null;

            // Kiểm tra null của bảng Department
            if (account.getDepartment() != null) {
                this.departmentName = account.getDepartment().getDepartmentName();
            }

            // Kiểm tra null của bảng Position
            if (account.getPosition() != null && account.getPosition().getPositionName() != null) {
                this.positionName = account.getPosition().getPositionName().getValue();
            }
        }
    }

    // --- Hệ thống Getter và Setter để Spring Boot đóng gói JSON
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}

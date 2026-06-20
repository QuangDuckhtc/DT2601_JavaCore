package com.vti.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AccountCreateForm {

    @NotBlank(message = "Username không được để trống")
    @Size(min = 5, max = 20, message = "Username từ 5 đến 20 ký tự")

    private String username;
    @NotBlank(message = "Password không được để trống")
    @Size(min = 8, max = 20, message = "Password từ 8 đến 20 ký tự")
    // Regex cho password: Phải có ít nhất 1 chữ hoa, 1 chữ thường và 1 số
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password phải bao gồm chữ hoa, chữ thường và chữ số")
    private String password;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(max = 50, message = "Họ tên không quá 50 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    private Integer departmentId;
    private Integer positionId;

    // --- Tạo đầy đủ Getter và Setter ở dưới này ---
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}

package entity;

import java.time.LocalDate;

public class Account {
    private int accountID;
    private String email;
    private String username;
    private String fullName;
    private Department department;
    private PositionName positionName;
    private LocalDate createDate;

    public Account(){

    }


    public Account(int accountID, LocalDate createDate, PositionName positionName, Department department, String username, String email, String fullName) {
        this.accountID = accountID;
        this.createDate = createDate;
        this.positionName = positionName;
        this.department = department;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", positionName=" + positionName +
                ", createDate=" + createDate +
                '}';
    }
}

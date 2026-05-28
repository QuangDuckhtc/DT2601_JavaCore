package dto.csv;

public class AccountCsv {
    private String username;

    private String fullName;

    private String email;

    private String departmentID;

    private String positionName;

    public AccountCsv(
            String username,
            String fullName,
            String email,
            String departmentID,
            String positionName
    ) {

        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.departmentID = departmentID;
        this.positionName = positionName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}

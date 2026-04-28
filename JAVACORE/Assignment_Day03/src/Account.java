import java.time.LocalDate;

public class Account {
     int accountID;
     String email;
     String userName;
     String fullName;
     Department department;
     Position position;
     LocalDate createDate;
     float salary;

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                '}';
    }
}

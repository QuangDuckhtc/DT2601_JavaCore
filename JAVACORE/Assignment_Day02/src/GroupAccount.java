import java.util.Date;

public class GroupAccount {
    private Date joinDate;
    private Group group;
    private Account account;

    public GroupAccount(Date joinDate, Group group, Account account) {
        this.joinDate = joinDate;
        this.group = group;
        this.account = account;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "GroupAccount{" +
                "joinDate=" + joinDate +
                ", group=" + group +
                ", account=" + account +
                '}';
    }
}

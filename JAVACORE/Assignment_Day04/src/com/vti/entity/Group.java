import java.util.Arrays;
import java.util.Date;

public class Group {
    private int groupID;
    private String groupName;
    private Date createDate;
    private Account[] accounts;


    public Group(int groupID, String groupName, Date createDate, Account[] accounts) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.createDate = createDate;
        this.accounts = accounts;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", createDate=" + createDate +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}

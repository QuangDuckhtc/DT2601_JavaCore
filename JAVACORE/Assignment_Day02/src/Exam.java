import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Exam {
    private int examID;
    private String code;
    private String title;
    private CategoryQuestion categoryQuestion;
    private LocalTime duration;
    private Account account;
    private LocalDateTime createDate;


    public Exam(int examID, String code, String title, CategoryQuestion categoryQuestion, LocalTime duration, Account account, LocalDateTime createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryQuestion = categoryQuestion;
        this.duration = duration;
        this.account = account;
        this.createDate = createDate;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examID=" + examID +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", duration=" + duration +
                ", account=" + account +
                ", createDate=" + createDate +
                '}';
    }
}

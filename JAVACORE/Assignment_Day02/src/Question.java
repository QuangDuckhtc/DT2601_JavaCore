import java.time.LocalDate;

public class Question {
    private int questionID;
    private String content;
    private CategoryQuestion categoryQuestion;
    private TypeQuestion typeQuestion;
    private Account account;
    private LocalDate createDate;

    public Question(int questionID, String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion, Account account, LocalDate createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryQuestion = categoryQuestion;
        this.typeQuestion = typeQuestion;
        this.account = account;
        this.createDate = createDate;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", typeQuestion=" + typeQuestion +
                ", account=" + account +
                ", createDate=" + createDate +
                '}';
    }
}

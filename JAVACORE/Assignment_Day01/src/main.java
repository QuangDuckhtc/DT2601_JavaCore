import java.time.LocalDate;
import java.time.LocalTime;

public class main {
    static void main(String[] args) {
//         Tạo file Program.java có chứa main() method và khởi tạo ít nhất 3 đối tượng đối với mỗi table trong java
        Department department1 = new Department();
        Department department2 = new Department();
        Department department3 = new Department();

        department1.departmentID = 1;
        department2.departmentName = "Sale";
        department2.departmentID = 2;
        department3.departmentName = "Marketing";
        department3.departmentID = 3;
        department1.departmentName = "Bảo vệ";


        Position position1 = new Position();
        Position position2 = new Position();
        Position position3 = new Position();

        position1.positionID = 1;
        position1.positionName = Position.PositionName.TEST;

        position2.positionID = 2;
        position2.positionName = Position.PositionName.DEV;

        position3.positionID = 3;
        position3.positionName = Position.PositionName.SCRUM_MASTER;


        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        account1.accountID = 1;
        account1.email = "ken@gmail.com";
        account1.userName = "Ken";
        account1.fullName = "Nguyen Ken";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.now();


        account2.accountID = 2;
        account2.email = "Duc@gmail.com";
        account2.userName = "Duc";
        account2.fullName = "Nguyen Quang Duc";
        account2.department = department1;
        account2.position = position1;
        account2.createDate = LocalDate.of(2026, 2, 4);


        account3.accountID = 3;
        account3.email = "ken@gmail.com";
        account3.userName = "Ken";
        account3.fullName = "Nguyen Ken";
        account3.department = department1;
        account3.position = position1;
        account3.createDate = LocalDate.now();


        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();

        group1.groupID = 1;
        group1.groupName = "Backend Team";
        group2.groupID = 2;
        group2.groupName = "Frontend Team";
        group3.groupID = 3;
        group3.groupName = "Backend Team";

        GroupAccount groupAccount1 = new GroupAccount();
        GroupAccount groupAccount2 = new GroupAccount();
        GroupAccount groupAccount3 = new GroupAccount();

        groupAccount1.group = group1;
        groupAccount1.account = account1;
        groupAccount2.group = group2;
        groupAccount2.account = account2;
        groupAccount3.group = group3;
        groupAccount3.account = account3;


        TypeQuestion typeQuestion1 = new TypeQuestion();
        TypeQuestion typeQuestion2 = new TypeQuestion();
        TypeQuestion typeQuestion3 = new TypeQuestion();

        typeQuestion1.typeID = 1;
        typeQuestion1.typeName = TypeQuestion.TypeName.ESSAY;
        typeQuestion2.typeID = 2;
        typeQuestion2.typeName = TypeQuestion.TypeName.MULTIPLE_CHOICE;
        typeQuestion3.typeID = 3;
        typeQuestion3.typeName = TypeQuestion.TypeName.MULTIPLE_CHOICE;

        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion1.categoryID = 1;
        categoryQuestion1.categoryName = "Java";
        categoryQuestion1.categoryID = 2;
        categoryQuestion1.categoryName = "SQL";
        categoryQuestion1.categoryID = 3;
        categoryQuestion1.categoryName = "Postman";

        Question question1 = new Question();
        Question question2 = new Question();
        Question question3 = new Question();

        question1.questionID = 1;
        question1.content = " Java là gì ?.";
        question1.typeQuestion = typeQuestion1;
        question1.account = account1;
        question1.createDate = LocalDate.of(2025, 12, 2);


        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();

        answer1.answerID = 1;
        answer1.content = "Là ngôn ngữ lập trình ";
        answer1.question = question1;
        answer1.isCorrect = true;

        Exam exam1 = new Exam();
        Exam exam2 = new Exam();
        Exam exam3 = new Exam();
        exam1.examID = 1;
        exam1.code = "123ABC";
        exam1.title = "Thi Giữa Kỳ";
        exam1.duration = LocalTime.of(1, 0);
        exam1.account = account3;
        exam1.createDate = LocalDate.of(2025, 11, 3);

        ExamQuestion examQuestion1 = new ExamQuestion();
        ExamQuestion examQuestion2 = new ExamQuestion();
        ExamQuestion examQuestion3 = new ExamQuestion();

        examQuestion1.exam = exam1;
        examQuestion1.question = question1;


        //  Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối tượng ra.
        System.out.printf("==== Department 1 info ====\n" +
                        "Department ID:%d\n " +
                        "Departement Name:%s\n",
                department1.departmentID,
                department1.departmentName
        );
        System.out.println("Position 1 info: " + "Postition ID: " + position1.positionID + "||" + " Position Name: " + position1.positionName);
        System.out.printf(
                "==== Account Info ====\n" +
                        "ID: %d\n" +
                        "Email: %s\n" +
                        "User Name: %s\n" +
                        "Full Name: %s\n" +
                        "Department: %s\n" +
                        "Position: %s\n" +
                        "Create Date: %s\n",
                account1.accountID,
                account1.email,
                account1.userName,
                account1.fullName,
                account1.department.departmentName,
                account1.position.positionName,
                account1.createDate
        );
        System.out.printf("==== Group ====\n");
        System.out.printf("ID: %d | Name: %s\n", group1.groupID, group1.groupName);

        System.out.printf("==== GroupAccount ====\n");
        System.out.printf("Group: %s | User: %s\n", groupAccount2.group.groupName, groupAccount2.account.userName);

        System.out.printf("==== TypeQuestion ====\n");
        System.out.printf("ID: %d | Type: %s\n", typeQuestion1.typeID, typeQuestion1.typeName);

        System.out.printf("=== CategoryQuestion ===\n");
        System.out.printf("ID: %d | Name: %s\n", categoryQuestion1.categoryID, categoryQuestion1.categoryName);

        System.out.printf("=== Question ===\n");
        System.out.printf("ID: %d | Content: %s | Type: %s | Creator: %s\n",
                question1.questionID, question1.content,
                question1.typeQuestion.typeName,
                question1.account.userName);

        System.out.printf("\n=== Answer ===\n");
        System.out.printf("ID: %d | Content: %s | Correct: %b\n",
                answer1.answerID, answer1.content, answer1.isCorrect);

        System.out.printf("\n=== Exam ===\n");
        System.out.printf("ID: %d | Code: %s | Title: %s | Duration: %s | Creator: %s\n",
                exam1.examID, exam1.code, exam1.title,
                exam1.duration,
                exam1.account.userName);

        System.out.printf("\n=== ExamQuestion ===\n");
        System.out.printf("Exam: %s | Question: %s\n",
                examQuestion1.exam.title,
                examQuestion1.question.content);

    }
}

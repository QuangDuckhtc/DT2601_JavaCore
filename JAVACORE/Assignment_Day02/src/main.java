import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Department d1 = new Department(1, "BackEnd");
        Department d2 = new Department(2, "Hr");
        Department d3 = new Department(3, "Frontend");
        Department[] departments = {d1, d2, d3};

        Position position = new Position(1, Position.PositionName.PM);
        Position position1 = new Position(2, Position.PositionName.DEV);

        Account account = new Account(1, "quangduc@gmail.com", "Duc", "Quang Duc", d2, position, LocalDate.now());
        Account account1 = new Account(2, "test1@gmail.com", "test", "test1", d1, position1, LocalDate.now());
        Account account2 = new Account(5, "test2@gmail.com", "test2", "test2", d3, position1, LocalDate.now());
        Account[] accounts = {account, account1, account2};

        TypeQuestion type1 = new TypeQuestion(1, TypeQuestion.TypeName.ESSAY);
        TypeQuestion type2 = new TypeQuestion(2, TypeQuestion.TypeName.MULTIPLE_CHOICE);


        CategoryQuestion cate1 = new CategoryQuestion(1, "question1");
        CategoryQuestion cate2 = new CategoryQuestion(1, "question2");

        Question q1 = new Question(1, "Java là gì?", cate1, type1, account, LocalDate.of(2026, 4, 23));
        Question q2 = new Question(2, "SELECT dùng để làm gì?", cate2, type2, account1, LocalDate.of(2025, 12, 10));

        Question[] questions ={q1,q2};
        Group group = new Group(1, "Hộ nghèo vượt khó", new Date(), accounts);
        Group group1 = new Group(2, "Vượt lên chính mình ", new Date(), accounts);
        Group[] groups = {group,group1};
        Exam exam1 = new Exam(1, "EX001", "Java Basic Exam", cate1, LocalTime.of(1, 30), account, LocalDateTime.of(2026, 4, 23, 12,20,00));
        Exam exam2 = new Exam(2, "EX002", "SQL Basic Exam", cate1, LocalTime.of(2, 0), account1, LocalDateTime.of(2025, 12, 10, 13,25,15));
        exam1.setCreateDate(LocalDateTime.of(2026, 4, 23, 14, 30, 10));
        Exam[] exams = {exam1,exam2};

//
//        Exercise1.Question1(account);
//        Exercise1.Question2(account,2);
//        Exercise1.Question3(account);
//        Exercise1.Question4(account1);
//        Exercise1.Question5(group);
//        Exercise1.Question6(account1,3);
//        Exercise1.Question7(account);
//        Exercise1.Question8(accounts);
//        Exercise1.Question9(departments);
//        Exercise1.Question10(accounts);
//        Exercise1.Question11(departments);
//        Exercise1.Question12(departments);
//        Exercise1.Question13(accounts);
//        Exercise1.Question14(accounts);
//        Exercise1.Question15();

//        Exercise2.question1(5);
//        Exercise2.question2(100000000);
//
//
//        Exercise2.question5(accounts);
//        Exercise3.question1(exams);

//        Exercise3.question1(exams);
//        Exercise3.question2(exams);
//        Exercise3.question3(questions);
//        Exercise3.question4(questions);
//        Exercise3.question5(questions);

//        Exercise4.question1();
//        Exercise4.question2();
//        Exercise4.question3();
//        Exercise4.question4();
//        Exercise4.question5();
//        Exercise4.question6();
//        Exercise4.question7();


//        Exercise5.question1();
//        Exercise5.question4();
//        Exercise5.question5();
//        Exercise5.question6();
//        Exercise5.question7();
//         Exercise5.question8();
//        Exercise5.question9(accounts,groups);
//        Exercise5.question10();
//        Exercise5.question11(accounts,groups);
          Exercise6.question1();
          Exercise6.question2(accounts);
          Exercise6.question3();
    }


}

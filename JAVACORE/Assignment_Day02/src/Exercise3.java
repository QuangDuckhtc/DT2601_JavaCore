import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercise3 {
    public static void question1(Exam[] exams) {

        if (exams == null || exams.length == 0) return;

        Exam exam1 = exams[0];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Thông tin Exam thứ 1:");
        System.out.println("ID: " + exam1.getExamID());
        System.out.println("Code: " + exam1.getCode());
        System.out.println("Title: " + exam1.getTitle());
        System.out.println("Create Date: " + exam1.getCreateDate().format(formatter));
    }

    public static void question2(Exam[] exams) {

        if (exams == null || exams.length == 0) return;
        Exam exam = exams[1];
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy - MM - dd - HH - mm - ss");

        System.out.println("Exam đã tạo ngày: " +
                exam.getCreateDate().format(formatter));
    }

    public static void question3(Question[] questions) {

        if (questions == null || questions.length == 0) return;

        Question q2 = questions[1];

        System.out.println("Năm của create date Question 2 là: " + q2.getCreateDate().getYear());
    }

    public static void question4(Question[] questions) {

        if (questions == null || questions.length == 0) return;

        Question q2 = questions[1];

        LocalDate date = q2.getCreateDate();

        System.out.println("Tháng - Năm của Question 2 là: " + date.getMonthValue() + " - " + date.getYear());
    }
    public static void question5(Question[] questions) {

        if (questions == null || questions.length == 0) return;

        Question q2 = questions[1]; // Question 2

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MM-dd");

        System.out.println("MM-DD: " + q2.getCreateDate().format(formatter));
    }

}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise2 {
    public static void question1 ( int  x){
        System.out.printf("số nguyên x: là %d%n", x);
    }
    public static void question2 (int  x){
        System.out.printf("%,d%n", x);
    }
    public static void question3(float x ){
        System.out.printf("%.4f%n", x);
    }
    public static void question4(String name ){
        System.out.printf("Tên tôi là: \"%s\" và tôi đang độc thân.%n");
    }
    public static void question4( ){
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'm':ss's'");

        System.out.println(now.format(formatter));
    }
    public static void question5(Account[] accounts ){
        String line = "+-----+--------------------------------+---------------------------+----------------------+";

        System.out.println(line);
        System.out.printf("| %-3s | %-30s | %-25s | %-20s |\n",
                "ID", "Email", "Full Name", "Department");
        System.out.println(line);

        for (Account acc : accounts) {

            String deptName = (acc.getDepartment() != null)
                    ? acc.getDepartment().getDepartmentName()
                    : "N/A";
            System.out.printf("| %-3d | %-30s | %-25s | %-20s |\n",
                    acc.getAccountID(),
                    acc.getEmail(),
                    acc.getFullName(),
                    deptName);
        }

        System.out.println(line);
    }

}

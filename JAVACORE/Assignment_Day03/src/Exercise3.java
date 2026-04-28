public class Exercise3 {

    public static void question1() {
//    object -> số thực
        Integer salary = 5000;
        float salaryConvert = salary.floatValue();
        System.out.printf("Salary = %.2f%n", salaryConvert);
    }

    public static void question2() {
        // string --> số
        String number = "1234567";

        int result = Integer.parseInt(number);

        System.out.println(result);
    }

    public static void question3() {
//        String --> Object --> int
        Integer number = Integer.valueOf("1234567");

        int result = number.intValue();

        System.out.println(result);
    }
}
public class Exercise6 {
    public static void question1() {

        for (int i = 2; i < 10; i += 2) {
            System.out.println(i);
        }
    }
    public static void question2(Account[] accounts) {

        System.out.println("Danh sách account:");

        for (int i = 0; i < accounts.length; i++) {

            System.out.println("Account " + (i + 1));
            System.out.println("Username: " + accounts[i].getUserName());
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("-------------------");
        }
    }
    public static void question3() {

        System.out.println("Các số nguyên dương nhỏ hơn 10:");

        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }
}

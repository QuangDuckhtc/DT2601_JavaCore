import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

    static int randomNumber;
    public static  void question1() {
        Account acc1 = new Account();
        Account acc2 = new Account();

        acc1.salary = 5240.5f;
        acc2.salary = 10970.055f;
//        ép kiểu float --> int ;
        int salary1 = (int) acc1.salary;
        int salary2 = (int) acc2.salary;

        System.out.println("Luong account 1: " + salary1);
        System.out.println("Luong account 2: " + salary2);
    }
    public static void question2(){
        Random random = new Random();

        randomNumber = random.nextInt(1000000);
        System.out.printf("random số có 5 chữ số: %05d%n ", randomNumber);

    }
    public static void question3() {
        //     Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối

        String number = String.format("%05d", randomNumber);

        String lastTwoConvert1 = number.substring(number.length() - 2);

        System.out.println("Lấy ra 2 số cuối là cách 1: " + lastTwoConvert1);


        //   Cách 2: chia lấy dư số đó cho 100
        int lastTwoConvert2 = randomNumber % 100;

        System.out.println("2 số cuối là cách 2: " + lastTwoConvert2);
    }
    public static void question4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên a: ");
        int a = sc.nextInt();
        System.out.println("Nhập số nguyên b: ");
        int b = sc.nextInt();
        if ( b == 0 ){
            System.out.println("không chia được cho 0 ");
        }
        System.out.println( a + "\\" + b + " = "+ ((float) a/b));

    }

}

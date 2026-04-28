import java.util.Scanner;

public class Exercise4 {
    public static void question1() {
        System.out.println("++++================question1================++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        // Xóa khoảng trắng đầu cuối
        str = str.trim();
        // b2. tách chuỗi khi có khoảng nhiều khoảng trắng
        String[] words = str.split("\\s+");

        System.out.println("Số lượng từ là: " + words.length);

    }

    public static void question2() {
        System.out.println("++++================question2================++++");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi s1: ");
        String s1 = sc.nextLine();
        System.out.println("Nhập chuỗi s2: ");
        String s2 = sc.nextLine();

//        nối 2 chuỗi : concat ;
        String result = s1.concat(" ").concat(s2);

        System.out.println("Chuỗi sau khi nối là: " + result);
    }

    public static void question3() {
        System.out.println("++++==================question3==============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        // Viết hoa chữ cái đầu
        String firstUpperCase = name.substring(0, 1).toUpperCase();

        // Các ký tự còn lại viết thường
        String remaining = name.substring(1).toLowerCase();

        String result = firstUpperCase.concat(remaining);

        System.out.println("Tên của bạn là:  " + result);
    }

    public static void question4() {
        System.out.println("++++==================question4==============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        for (int i = 0; i < name.length(); i++) {

            System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
        }
    }

    public static  void question5() {
        System.out.println("++++===================question5=============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mời bạn nhập họ: ");
        String lastName = scanner.nextLine();

        System.out.print("Mời bạn nhập tên: ");
        String firstName = scanner.nextLine();

        // Ghép họ và tên
        String fullName = lastName.concat(" ").concat(firstName);

        System.out.println("Họ và tên của bạn là : " + fullName);
    }

    public static void question6() {
        System.out.println("++++==================question6==============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên đầy đủ: ");

        String fullName = scanner.nextLine();

        // Xóa khoảng trắng đầu cuối
        fullName = fullName.trim();

        // Tách chuỗi theo khoảng trắng
        String[] words = fullName.split("\\s+");

        // Họ
        String lastName = words[0];

        // Tên
        String firstName = words[words.length - 1];

        // Tên đệm
        String middleName = "";

        for (int i = 1; i < words.length - 1; i++) {

            middleName += words[i] + " ";
        }

        System.out.println("Họ là: " + lastName);

        System.out.println("Tên đệm là: " + middleName.trim());

        System.out.println("Tên là: " + firstName);
    }

    public static void question7() {
        System.out.println("++++==================question7==============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên: ");

        String fullName = scanner.nextLine();


        //a  Xóa khoảng trắng đầu cuối
        fullName = fullName.trim();

        // Tách chuỗi theo nhiều khoảng trắng
        String[] words = fullName.split("\\s+");


        //  b. Viết hoa chữ cái đầu =====
        String result = "";
        for (String word : words) {

            // Lấy chữ cái đầu viết hoa
            String firstChar = word.substring(0, 1).toUpperCase();
            // Phần còn lại viết thường
            String remaining = word.substring(1).toLowerCase();

            // Ghép lại
            result = result.concat(firstChar)
                    .concat(remaining)
                    .concat(" ");
        }
        System.out.println("Họ tên sau chuẩn hóa là: " + result.trim());
    }

    public static void question8() {
        System.out.println("++++================question8================++++");
        Group[] groups = new Group[5];

        groups[0] = new Group();
        groups[0].name = "Java";

        groups[1] = new Group();
        groups[1].name = "Java Core";

        groups[2] = new Group();
        groups[2].name = "ReactJS";

        groups[3] = new Group();
        groups[3].name = "Java Fresher";

        groups[4] = new Group();
        groups[4].name = "DevOps";

        for (Group group : groups) {

            if (group.name.contains("Java")) {

                System.out.println(group);
            }
        }
    }

    public static void question9() {
        System.out.println("++++=================question9===============++++");
        Group[] groups = new Group[5];

        groups[0] = new Group();
        groups[0].name = "Java";

        groups[1] = new Group();
        groups[1].name = "Java Core";

        groups[2] = new Group();
        groups[2].name = "ReactJS";

        groups[3] = new Group();
        groups[3].name = "Java";

        groups[4] = new Group();
        groups[4].name = "DevOps";


        for (Group group : groups) {

            if (group.name.equals("Java")) {

                System.out.println(group.name);
            }
        }
    }

    public static void question10() {
        System.out.println("++++==================question10==============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi thứ 1: ");
        String s1 = scanner.nextLine();

        System.out.print("Nhập chuỗi thứ 2: ");
        String s2 = scanner.nextLine();

        // Đảo ngược s1
        String reverse = "";

        for (int i = s1.length() - 1; i >= 0; i--) {
            // word ; [3] --> d , [2] --> r ......
            reverse = reverse.concat(String.valueOf(s1.charAt(i)));
        }

        if (reverse.equals(s2)) {

            System.out.println("OK");

        } else {

            System.out.println("KO");
        }
    }

    public static void question11() {
        System.out.println("++++=================question11===============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");

        String str = scanner.nextLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'a') {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự a là: " + count);
    }

    public static void question12() {
        // tương tự bài 10

        System.out.println("++++===============question12=================++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");

        String str = scanner.nextLine();

        String reverse = "";

        // lặp lấy giá trị ngược
        for (int i = str.length() - 1; i >= 0; i--) {

            reverse = reverse.concat(
                    String.valueOf(str.charAt(i))
            );
        }
        System.out.println("Chuỗi đảo ngược là: " + reverse);
    }

    public static void question13() {
        System.out.println("++++==================question13==============++++");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        if (str == null || str.isEmpty()) {
            System.out.println(false);
            return;
        }
        // lặp kiểm tra từng ký tự
        for (int i = 0; i < str.length(); i++) {

            // Nếu là số thì trả về false
            if (Character.isDigit(str.charAt(i))) {

                System.out.println(false);

                return;
            }
        }

        System.out.println(true);
    }

    public static void question14() {
        System.out.println("++++===================question14=============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        // Thay ký tự e thành *
        String result = str.replace('e', '*');

        System.out.println("Chuỗi sau khi thay là: " + result);
    }

    public static void question15() {
        System.out.println("++++==================question15==============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");

        String str = scanner.nextLine();

        // Xóa khoảng trắng đầu cuối
        str = str.trim();

        // Tách chuỗi thành mảng
        String[] words = str.split(" ");

        // Đảo ngược từ
        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {

            result = result.concat(words[i]);

            if (i != 0) {

                result = result.concat(" ");
            }
        }
        System.out.println("Chuỗi đảo ngược là: " + result);
    }

    //    question 16: Cắt chuỗi thành nhiều đoạn nhỏ, mỗi đoạn có  n ký tự.
    public static void question16() {

        System.out.println("++++===================question16=============++++");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");

        String str = scanner.nextLine();

        System.out.print("Nhập n: ");

        int n = scanner.nextInt();

        // Kiểm tra có chia được không
        if (str.length() % n != 0) {

            System.out.println("KO");

            return;
        }

        // Chia chuỗi theo n
        for (int i = 0; i < str.length(); i += n) {

            System.out.println(
                    str.substring(i, i + n)
            );
        }
    }

}

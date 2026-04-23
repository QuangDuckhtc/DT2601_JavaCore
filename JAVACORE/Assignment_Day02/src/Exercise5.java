import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {
    public static void question1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên 1: ");
        int a = sc.nextInt();

        System.out.print("Nhập số nguyên 2: ");
        int b = sc.nextInt();

        System.out.print("Nhập số nguyên 3: ");
        int c = sc.nextInt();

        System.out.println("3 số bạn nhập là: " + a + ", " + b + ", " + c);
    }

    public static void question2() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thực 1: ");
        double a = sc.nextDouble();

        System.out.print("Nhập số thực 2: ");
        double b = sc.nextDouble();

        System.out.println("2 số thực: " + a + " - " + b);
    }

    public static void question3() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.print("Nhập họ và tên: ");
        String fullName = sc.nextLine();

        System.out.println("Họ tên: " + fullName);
    }

    public static void question4() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập năm: ");
        int year = sc.nextInt();

        System.out.print("Nhập tháng: ");
        int month = sc.nextInt();

        System.out.print("Nhập ngày: ");
        int day = sc.nextInt();

        LocalDate birth = LocalDate.of(year, month, day);

        System.out.println("Ngày sinh: " + birth);
    }

    public static void question5() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập User name: ");
        String username = sc.nextLine();
        System.out.print("Nhập Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Position (1-4): ");
        int pos = sc.nextInt();

        Position.PositionName position;

        switch (pos) {
            case 1:
                position = Position.PositionName.DEV;
                break;
            case 2:
                position = Position.PositionName.TEST;
                break;
            case 3:
                position = Position.PositionName.SCRUM_MASTER;
                break;
            case 4:
                position = Position.PositionName.DEV;
                break;
            default:
                System.out.println("Nhập sai đầu vào: ");
                return;
        }

        System.out.println("Thông tin Account: " + username + fullName + " - " + position);
    }

    public static void question6() {

        Scanner sc = new Scanner(System.in);

        Department department = new Department();

        System.out.print("Nhập department id: ");
        department.setDepartmentID(sc.nextInt());

        sc.nextLine();

        System.out.print("Nhập department name: ");
        department.setDepartmentName(sc.nextLine());

        System.out.println("Department vừa tạo:");
        System.out.println("Id: " + department.getDepartmentID());
        System.out.println("Name: " + department.getDepartmentName());
    }

    public static void question7() {


        Scanner sc = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Nhập số chẵn: ");
            number = sc.nextInt();

            if (number % 2 == 0) {
                System.out.println("Bạn đã nhập số chẵn: " + number);
                break;
            } else {
                System.out.println("vui lòng nhập số chẵn!");
            }

        }
    }

    public static void question8(Account[] accounts, Group[] groups) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("===== MENU =====");
            System.out.println("1. Tạo account");
            System.out.println("2. Tạo department");
            System.out.println("3. Thêm group vào account");
            System.out.println("4. Thêm account vào group ngẫu nhiên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Chức năng: Tạo account");
                    // question5 ;
                    break;

                case 2:
                    System.out.println("Chức năng: Tạo department");
                    //  question6();
                    break;

                case 3:
                    System.out.println("Chức năng: Thêm group vào account");
                    // question9(accounts, groups);
                    break;

                case 4:
                    System.out.println("Chức năng: Thêm account vào group ngẫu nhiên");
//                    question11(accounts, groups); //
                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    return;

                default:
                    System.out.println("Sai lựa chọn, nhập lại!");
            }

            // hỏi có muốn tiếp tục không
            sc.nextLine();
            System.out.print("Bạn có muốn tiếp tục không? (y/n): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Kết thúc chương trình");
                return;
            }
        }
    }

    public static void question9(Account[] accounts, Group[] groups) {

        Scanner sc = new Scanner(System.in);

        // In danh sách user
        System.out.println("Danh sách user:");
        for (Account a : accounts) {
            System.out.println(a.getUserName());
        }


        // In danh sách group
        System.out.println("Danh sách group:");
        for (Group g : groups) {
            System.out.println(g.getAccounts());
        }

        System.out.print("Nhập username: ");
        String username = sc.nextLine();
        System.out.print("Nhập tên group: ");
        String groupName = sc.nextLine();


        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getUserName().equals(username)) {

                for (int j = 0; j < groups.length; j++) {
                    if (groups[j].getGroupName().equals(groupName)) {

                        System.out.println("Đã chọn user " + username +
                                " vào group " + groupName);
                        return;
                    }
                }
            }
        }

        System.out.println("Không tìm thấy user hoặc group!");
    }

    public static void question10() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Mời bạn chọn chức năng:");
            System.out.println("1. Tạo account");
            System.out.println("2. Tạo department");
            System.out.println("3. Thêm group vào account");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Chức năng tạo account");

            } else if (choice == 2) {
                System.out.println("Chức năng tạo department");

            } else if (choice == 3) {
                System.out.println("Chức năng thêm group vào account");

            } else {
                System.out.println("Sai lựa chọn, nhập lại!");
                continue;
            }

            sc.nextLine();
            System.out.print("Bạn có muốn thực hiện chức năng khác không? (y/n): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Kết thúc chương trình");
                return;
            }
        }
    }

    public static void question11(Account[] accounts, Group[] groups) {

        Scanner sc = new Scanner(System.in);

//   in tên user
        System.out.println("Danh sách user:");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].getUserName());
        }

// Nhập username
        System.out.print("Nhập username: ");
        String username = sc.nextLine();
        // Bước 3: chọn random group
        Random random = new Random();
        int index = random.nextInt(groups.length);

        // Bước 4: thông báo Thêm account vào group chương trình vừa chọn ngẫu nhiên
        System.out.println("User " + username + " được thêm vào group ngẫu nhiên: " + groups[index].getGroupName());
    }
}



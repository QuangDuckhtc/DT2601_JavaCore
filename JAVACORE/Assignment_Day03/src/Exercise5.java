public class Exercise5 {
    public static void question1() {
        System.out.println("==============================");
        Department department1 = new Department();

        department1.departmentID = 1;
        department1.departmentName = "Sale";

        System.out.println(department1.toString());
    }


    public static void question2() {
        System.out.println("==============================");
        Department[] departments = new Department[3];


        departments[0] = new Department();
        departments[0].departmentID = 1;
        departments[0].departmentName = "Sale";


        departments[1] = new Department();
        departments[1].departmentID = 2;
        departments[1].departmentName = "Bảo vệ";


        departments[2] = new Department();
        departments[2].departmentID = 3;
        departments[2].departmentName = "Phụ hồ";


        for (Department department : departments) {

            System.out.println(department.toString());
        }
    }

    public static void question3() {
        System.out.println("==============================");
        Department department1 = new Department();

        department1.departmentID = 1;
        department1.departmentName = "Sale";

        //địa chỉ object --> object lưu ở head
        System.out.println(department1.hashCode());
    }

    public static void question4() {
        System.out.println("==============================");
        Department department1 = new Department();

        department1.departmentID = 1;
        department1.departmentName = "Phòng A";

        // so sánh nội dung
        if (department1.departmentName.equals("Phòng A")) {

            System.out.println("Có");

        } else {

            System.out.println("Không");
        }
    }

    public static void question5() {
        System.out.println("==============================");
        Department department1 = new Department();

        department1.departmentID = 1;
        department1.departmentName = "Sale";


        Department department2 = new Department();

        department2.departmentID = 2;
        department2.departmentName = "Sale";


        if (department1.departmentName.equals(department2.departmentName)) {

            System.out.println("2 phòng ban bằng nhau");

        } else {

            System.out.println("2 phòng ban không bằng nhau");
        }
    }

    public static void question6() {
        System.out.println("==============================");
        Department[] departments = new Department[5];


        departments[0] = new Department();
        departments[0].departmentName = "Accounting";


        departments[1] = new Department();
        departments[1].departmentName = "Boss of director";


        departments[3] = new Department();
        departments[3].departmentName = "Marketing";


        departments[2] = new Department();
        departments[2].departmentName = "Sale";


        departments[4] = new Department();
        departments[4].departmentName = "Waiting room";


        // Sắp xếp tăng dần theo thứ tự phân biệt chữa hoa ABC  --> tương tự thuật toán selection  sort
        for (int i = 0; i < departments.length - 1; i++) {

            for (int j = i + 1; j < departments.length; j++) {

                if (departments[i].departmentName.compareTo(departments[j].departmentName) > 0) {

                    Department temp = departments[i];

                    departments[i] = departments[j];

                    departments[j] = temp;
                }
            }
        }

        for (Department department : departments) {

            System.out.println("Sắp xếp theo thứ tự tăng dần ABC: " + department.departmentName);
        }
    }

    public static void question7() {
        System.out.println("==============================");
        Department[] departments = new Department[5];


        departments[1] = new Department();
        departments[1].departmentName = "Accounting";


        departments[0] = new Department();
        departments[0].departmentName = "Boss of director";


        departments[4] = new Department();
        departments[4].departmentName = "Marketing";


        departments[2] = new Department();
        departments[2].departmentName = "Sale";


        departments[3] = new Department();
        departments[3].departmentName = "waiting room";


        // Sắp xếp tăng dần theo thứ tự phân biệt chữa hoa ABC  --> tương tự thuật toán selection  sort
        for (int i = 0; i < departments.length - 1; i++) {

            for (int j = i + 1; j < departments.length; j++) {

                if (departments[i].departmentName.compareToIgnoreCase(departments[j].departmentName) > 0) {

                    Department temp = departments[i];

                    departments[i] = departments[j];

                    departments[j] = temp;
                }
            }
        }

        for (Department department : departments) {

            System.out.println("Sắp xếp theo thứ tự tăng dần ko phân biệt hoa thường: " + department.departmentName);
        }
    }
}
import java.lang.classfile.instruction.SwitchCase;

public class Exercise1 {
    public static void question1(Account account) {
        if (account.getDepartment() == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là: " + account.getDepartment().getDepartmentName());
        }
    }

    public static void question2(Account account, int groupCount) {
        if (groupCount == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (groupCount == 1 || groupCount == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (groupCount == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public static void question3(Account account) {

        String result = account.getDepartment() == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là" + account.getDepartment().getDepartmentName();
        System.out.println(result);
    }

    public static void question4(Account account) {
        String result = account.getPosition().getPositionName() == Position.PositionName.DEV ? "Đây là developer" : "Người này không phải Developer";
        System.out.println(result);
    }

    //    SWITCH CASE
    public static void question5(Group group) {
        int count = group.getAccounts() == null ? 0 : group.getAccounts().length;
        switch (count) {
            case 1:
                System.out.println("Nhóm có 1 thành viên");
                break;
            case 2:
                System.out.println("Nhóm có 2 thành viên");
                break;
            case 3:
                System.out.println("Nhóm có 3 thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
    }

    public static void question6(Account acouunt, int groupCount) {
        switch (groupCount) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

        }
    }

    public static void question7(Account account) {
        switch (account.getPosition().getPositionName()) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Đây không phải là Developer");
        }
    }

    //    FOREACH
    public static void question8(Account[] accounts) {
        int i = 1;
        for (Account acc : accounts) {
            System.out.println("Email Account " + i + " là : " + acc.getEmail());
            System.out.println("Full Name Account  " + i + " là : " + acc.getFullName());
            System.out.println("Tên Phòng Ban Account " + i + " là : " + acc.getPosition().getPositionName());
            System.out.println("==============");
            i++;
        }
    }

    public static void question9(Department[] departments) {
        int i = 1;
        for (Department dpp : departments) {
            System.out.println("ID phòng ban  " + i + " là : " + dpp.getDepartmentID());
            System.out.println("Name phòng ban " + i + " là: " + dpp.getDepartmentName());
        }
    }

    //    FOR
    public static void question10(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            System.out.println("Thông tin account thứ " + (i + 1) + " là:  ");
            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
            System.out.println("========================");
        }
    }

    public static void question11(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            Department dpp = departments[i];
            System.out.println("Thông tin Department thứ " + (i + 1) + " là:  ");
            System.out.println("ID: " + dpp.getDepartmentID());
            System.out.println("Name: " + dpp.getDepartmentName());
            System.out.println("========================");
        }
    }

    public static void question12(Department[] departments) {
        for (int i = 0; i < departments.length && i < 2; i++) {
            Department dpp = departments[i];
            System.out.println("Thông tin Department thứ " + (i + 1) + " là:  ");
            System.out.println("ID: " + dpp.getDepartmentID());
            System.out.println("Name: " + dpp.getDepartmentName());
            System.out.println("========================");
        }
    }

    public static void question13(Account[] accounts) {

        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) {
                continue;
            }
            Account account = accounts[i];
            System.out.println("Thông tin account thứ " + (i + 1) + " là:  ");
            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
            System.out.println("========================");
        }
    }

    public static void question14(Account[] accounts) {

        for (int i = 0; i < accounts.length; i++) {


            Account account = accounts[i];
            if (account.getAccountID() < 4) {

                System.out.println("Thông tin account thứ " + (i + 1) + " là:  ");
                System.out.println("Email: " + account.getEmail());
                System.out.println("Full name: " + account.getFullName());
                System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
                System.out.println("========================");
            }
        }
    }

    public static void question15() {
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Số chẵn là: " + i);
        }
    }

    //    WHILE
    public static void question16_10(Account[] accounts) {

        int i = 0;
        while (i < accounts.length) {
            Account account = accounts[i];
            System.out.println("Thông tin account thứ " + (i + 1) + " là:  ");
            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
            System.out.println("========================");

            i++;


        }
    }

    public static void question16_11(Department[] departments) {

        int i = 0;
        while (i < departments.length) {
            Department dpp = departments[i];
            System.out.println("Thông tin Department thứ " + (i + 1) + " là:  ");
            System.out.println("ID: " + dpp.getDepartmentID());
            System.out.println("Name: " + dpp.getDepartmentName());
            System.out.println("========================");


        }
    }

    public static void question16_12(Department[] departments) {
        int i = 0;
        while (i < departments.length) {

            Department dpp = departments[i];
            System.out.println("Thông tin Department thứ " + (i + 1) + " là:  ");
            System.out.println("ID: " + dpp.getDepartmentID());
            System.out.println("Name: " + dpp.getDepartmentName());
            System.out.println("========================");
            if (i == 1) {
                break;
            }
            i++;
        }
    }

    public static void question16_13(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            if (i == 1) {
                continue;
            }

            Account account = accounts[i];
            System.out.println("Thông tin account thứ " + (i + 1) + " là:  ");
            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
            System.out.println("========================");

            i++;


        }
    }

    public static void question16_14(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            Account account = accounts[i];
            if (account.getAccountID() >= 4) {
                continue;
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:  ");
            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
            System.out.println("========================");

            i++;


        }

    }

    public static void question16_15() {
        int i = 0;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }

    //    DO-WHILE
    public static void question17_10(Account[] accounts) {
        int i = 0;

        if (accounts.length == 0) return;

        do {
            Account account = accounts[i];

            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
            System.out.println("====================");

            i++;
        } while (i < accounts.length);
    }

    public static void question17_11(Department[] departments) {
        int i = 0;

        if (departments.length == 0) return;

        do {
            Department d = departments[i];

            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + d.getDepartmentID());
            System.out.println("Name: " + d.getDepartmentName());
            System.out.println("====================");

            i++;
        } while (i < departments.length);
    }

    public static void question17_12(Department[] departments) {
        int i = 0;

        if (departments.length == 0) return;

        do {
            Department d = departments[i];

            System.out.println("Department thứ " + (i + 1));
            System.out.println("Id: " + d.getDepartmentID());
            System.out.println("Name: " + d.getDepartmentName());
            System.out.println("========================");

            if (i == 1) {
                break;
            }

            i++;
        } while (i < departments.length);
    }

    public static void question17_13(Account[] accounts) {
        int i = 0;

        if (accounts.length == 0) return;

        do {

            if (i == 1) {
                i++;
                continue;
            }

            Account account = accounts[i];

            System.out.println("Email: " + account.getEmail());
            System.out.println("Full name: " + account.getFullName());
            System.out.println("======================================");

            i++;
        } while (i < accounts.length);
    }

    public static void question17_14(Account[] accounts) {
        int i = 0;

        if (accounts.length == 0) return;

        do {
            Account account = accounts[i];

            if (account.getAccountID() >= 4) {
                i++;
                continue;
            }

            System.out.println("Account id < 4:");
            System.out.println(account.getEmail());

            i++;
        } while (i < accounts.length);
    }

    public static void question17_15() {
        int i = 1;

        do {
            if (i % 2 != 0) {
                i++;
                continue;
            }
            System.out.println("số chẵn <= 20: ");
            System.out.println(i);

            i++;
        } while (i <= 20);
    }
}



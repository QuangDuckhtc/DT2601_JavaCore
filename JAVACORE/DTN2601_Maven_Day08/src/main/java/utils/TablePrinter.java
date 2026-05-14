package utils;

public class TablePrinter {
    // ================= POSITION =================
    public static void printPositionHeader() {
        System.out.println("+-------+----------------------+");
        System.out.println("| ID    | POSITION NAME        |");
        System.out.println("+-------+----------------------+");
    }

    public static void printPositionRow(int id, String name) {
        System.out.printf("| %-5d | %-20s |\n", id, name);
    }

    public static void printPositionFooter() {
        System.out.println("+-------+----------------------+");
    }

    // ================= DEPARTMENT =================
    public static void printDepartmentHeader() {
        System.out.println("+-------+----------------------+");
        System.out.println("| ID    | DEPARTMENT NAME      |");
        System.out.println("+-------+----------------------+");
    }

    public static void printDepartmentRow(int id, String name) {
        System.out.printf("| %-5d | %-20s |\n", id, name);
    }

    public static void printDepartmentFooter() {
        System.out.println("+-------+----------------------+");
    }


    // ================= ACCOUNT =================
    public static void printAccountHeader() {
        System.out.println("+-------+---------------------------+----------------------+");
        System.out.println("| ID    | EMAIL                     | FULL NAME            |");
        System.out.println("+-------+---------------------------+----------------------+");
    }

    public static void printAccountRow(int id, String email, String fullName) {
        System.out.printf("| %-5d | %-25s | %-20s |\n",
                id, email, fullName);
    }

    public static void printAccountFooter() {
        System.out.println("+-------+---------------------------+----------------------+");
    }
}


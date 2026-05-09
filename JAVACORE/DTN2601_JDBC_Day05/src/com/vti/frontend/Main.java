package com.vti.frontend;

import com.vti.backend.QLAccount;
import com.vti.backend.QLDepartment;
import com.vti.backend.QLPosition;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    static void main(String[] args) {
        try {
            Connection connection = DButils.getConnection();
            if(connection != null){
                System.out.println("Kết nối databse thành công");
            }
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại");
            e.printStackTrace();
        }

        QLAccount qlAccount = new QLAccount();
        QLDepartment qlDepartment = new QLDepartment();
        QLPosition qlPosition = new QLPosition();


        System.out.println("================================ ACCOUNT LIST ================================================");
        List<Account> accounts = qlAccount.getAllAccounts();

        System.out.printf("| %-5s | %-20s | %-20s | %-15s | %-15s | %-12s |%n",
                "ID", "EMAIL", "FULL NAME", "DEPARTMENT", "POSITION", "DATE");

        System.out.println("-----------------------------------------------------------------------------------------------");

        for (Account a : accounts) {
            System.out.printf("| %-5d | %-20s | %-20s | %-15s | %-15s | %-12s |%n",
                    a.getAccountID(),
                    a.getEmail(),
                    a.getFullName(),
                    a.getDepartment().getDepartmentName(),
                    a.getPositionName(),
                    a.getCreateDate()
            );
        }

        System.out.println("\n================= DEPARTMENT LIST ==================");

        List<Department> departments = qlDepartment.getAllDepartments();
        System.out.printf("| %-5s | %-20s |%n", "ID", "NAME");
        System.out.println("------------------------------");

        for (Department d : departments) {

            System.out.printf("| %-5d | %-20s |%n", d.getDepartmentID(), d.getDepartmentName()
            );
        }

        System.out.println("\n=========== POSITION LIST ===========");

        List<Position> positions = qlPosition.getAllPositions();

        System.out.printf("| %-5s | %-20s |%n", "ID", "NAME");
        System.out.println("------------------------------");

        for (Position p : positions) {

            System.out.printf("| %-5d | %-20s |%n", p.getPositionID(), p.getPositionName()
            );
        }
    }

}

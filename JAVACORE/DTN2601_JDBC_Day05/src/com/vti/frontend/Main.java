package com.vti.frontend;

import com.vti.backend.QLAccount;
import com.vti.backend.QLDepartment;
import com.vti.backend.QLPosition;
import com.vti.utils.DButils;

import java.sql.Connection;
import java.sql.SQLException;

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
        System.out.println("==============THONG TIN DEPARTMENT================\n");
        QLDepartment dp = new QLDepartment();
        dp.getDepartment();
        System.out.println("==============THONG TIN  ACCOUNT====================\n");
        QLAccount acc = new QLAccount();
        acc.getAccounts();
        System.out.println("==============THONG TIN  POSITION====================\n");
        QLPosition po = new QLPosition();
        po.getPositions();
    }
}

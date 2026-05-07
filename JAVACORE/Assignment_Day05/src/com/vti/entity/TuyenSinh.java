package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class TuyenSinh implements ITuyenSinh {

    private List<ThiSinh> thiSinhs = new ArrayList<>();

    @Override
    public void addThiSinh(ThiSinh thiSinh) {
        thiSinhs.add(thiSinh);

        System.out.println("Them thi sinh thanh cong!");
    }

    @Override
    public void showInfo() {
        if (thiSinhs.isEmpty()) {

            System.out.println("Danh sach rong!");

            return;
        }

        for (ThiSinh ts : thiSinhs) {

            System.out.println(ts);
        }
    }

    @Override
    public void searchBySoBaoDanh(int soBaoDanh) {
        boolean found = false;

        for (ThiSinh ts : thiSinhs) {

            if (ts.getSoBaoDanh() == soBaoDanh) {

                System.out.println(ts);

                found = true;
            }
        }

        if (!found) {

            System.out.println("Khong tim thay!");
        }
    }
}


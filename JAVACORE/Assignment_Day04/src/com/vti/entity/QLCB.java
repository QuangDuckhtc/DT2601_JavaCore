package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class QLCB {
    private List<CanBo> canBos = new ArrayList<>();

    // thêm cán bộ
    public void addCanBo(CanBo cb) {
        canBos.add(cb);
    }

    // tìm theo tên
    public void searchByName(String name) {

        boolean found = false;

        for (CanBo cb : canBos) {

            if (cb.getFullName().equalsIgnoreCase(name)) {
                System.out.println(cb);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy cán bộ!");
        }
    }

    // hiển thị danh sách
    public void showList() {

        if (canBos.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        for (CanBo cb : canBos) {
            System.out.println(cb.toString());
        }
    }

    // xóa theo tên
    public void deleteByName(String name) {

        boolean found = false;

        for (int i = 0; i < canBos.size(); i++) {

            if (canBos.get(i).getFullName().equalsIgnoreCase(name)) {

                canBos.remove(i);

                found = true;

                System.out.println("Xóa thành công!");

                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy cán bộ để xóa!");
        }
    }
}

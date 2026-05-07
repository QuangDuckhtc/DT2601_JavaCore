package com.vti.entity;

public class DienThoaiThongMinh extends DienThoaiDiDong {

    public DienThoaiThongMinh(
            String tenDienThoai) {

        super(tenDienThoai);
    }

    public void suDung3G() {

        System.out.println(
                tenDienThoai + " dang su dung 3G"
        );
    }

    public void chupHinh() {

        System.out.println(
                tenDienThoai + " dang chup hinh"
        );
    }
}


package com.vti.entity;

public class DienThoaiCoDien extends DienThoaiDiDong {

    public DienThoaiCoDien(
            String tenDienThoai) {

        super(tenDienThoai);
    }

    public void ngheRadio() {

        System.out.println(tenDienThoai + " dang nghe radio");
    }
}

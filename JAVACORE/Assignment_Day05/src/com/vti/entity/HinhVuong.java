package com.vti.entity;

public class HinhVuong extends HinhChuNhat{

    public HinhVuong(double chieuDai, double chieuRong) {
        super(chieuDai, chieuRong);
    }

    public HinhVuong(double canh) {
        super(canh, canh);

    }

    // override chu vi
    @Override
    public double tinhChuVi() {
        System.out.println("Tinh chu vi theo Hinh Vuong");
        // gọi method class cha
        return super.tinhChuVi();
    }

    // override diện tích
    @Override
    public double tinhDienTich() {

        System.out.println("Tinh dien tich theo Hinh Vuong");

        // gọi method class cha
        return super.tinhDienTich();
    }
}

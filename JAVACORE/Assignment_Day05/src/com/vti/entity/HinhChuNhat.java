package com.vti.entity;

public class HinhChuNhat {
    protected double chieuDai;
    protected double chieuRong;


    public HinhChuNhat(double chieuDai, double chieuRong) {

        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double tinhChuVi() {

        System.out.println("Tinh chu vi theo Hinh Chu Nhat");

        return (chieuDai + chieuRong) * 2;
    }

    public double tinhDienTich() {

        System.out.println("Tinh dien tich theo Hinh Chu Nhat");

        return chieuDai * chieuRong;
    }
}

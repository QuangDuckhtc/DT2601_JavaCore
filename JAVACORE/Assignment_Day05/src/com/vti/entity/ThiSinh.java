package com.vti.entity;

public class ThiSinh {
    private int soBaoDanh;
    private String hoTen;
    private String diaChi;
    private int mucUuTien;

    public ThiSinh(int soBaoDanh,
                   String hoTen,
                   String diaChi,
                   int mucUuTien) {

        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
    }

    public int getSoBaoDanh() {
        return soBaoDanh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }

    @Override
    public String toString() {
        return "SoBaoDanh: " + soBaoDanh +
                ", HoTen: " + hoTen +
                ", DiaChi: " + diaChi +
                ", MucUuTien: " + mucUuTien;
    }
}

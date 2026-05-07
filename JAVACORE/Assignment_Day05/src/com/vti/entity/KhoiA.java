package com.vti.entity;

public class KhoiA extends ThiSinh{
    private final String monThi = "Toan - Ly - Hoa";
    public KhoiA(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }
    @Override
    public String toString() {

        return "Khoi A | " + super.toString() + ", MonThi: " + monThi;
    }
}

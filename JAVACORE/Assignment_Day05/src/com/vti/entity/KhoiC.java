package com.vti.entity;

public class KhoiC extends ThiSinh{
    private final String monThi = "Van - Su - Dia";

    public KhoiC(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }
    @Override
    public String toString() {

        return "Khoi C | " +
                super.toString() +
                ", MonThi: " + monThi;
    }
}

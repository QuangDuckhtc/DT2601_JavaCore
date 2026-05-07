package com.vti.entity;

public class KhoiB extends  ThiSinh{
    private final String monThi = "Toan - Hoa - Sinh";

    public KhoiB(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }
    @Override
    public String toString() {

        return "Khoi B | " +
                super.toString() +
                ", MonThi: " + monThi;
    }
}

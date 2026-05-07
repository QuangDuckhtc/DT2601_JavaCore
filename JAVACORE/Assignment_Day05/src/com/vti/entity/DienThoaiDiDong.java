package com.vti.entity;

public abstract class DienThoaiDiDong implements IVuKhi {

        protected String tenDienThoai;

        public DienThoaiDiDong(String tenDienThoai) {

            this.tenDienThoai = tenDienThoai;
        }

        public void nghe() {

            System.out.println(
                    tenDienThoai + " dang nghe dien"
            );
        }

        public void goi() {

            System.out.println(
                    tenDienThoai + " dang goi dien"
            );
        }

        public void guiTinNhan() {

            System.out.println(
                    tenDienThoai + " dang gui tin nhan"
            );
        }

        public void nhanTinNhan() {

            System.out.println(
                    tenDienThoai + " dang nhan tin nhan"
            );
        }

        @Override
        public void tanCongKeXau() {

            System.out.println(
                    tenDienThoai + " duoc dung lam vu khi"
            );
        }
    }


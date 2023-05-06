package com.hieupm.code_bhyt.dto.request;

public class TimKiemBhxhRequest {
    private String tinhThanhPho;
    private String hoTen;
    private String ngaySinh;

    public TimKiemBhxhRequest() {
    }

    public TimKiemBhxhRequest(String tinhThanhPho, String hoTen, String ngaySinh) {
        this.tinhThanhPho = tinhThanhPho;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public String getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}

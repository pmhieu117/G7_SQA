package com.hieupm.code_bhyt.dto.request;

public class ThanhVienHGDRequest {
    private String cccd,hoTen,ngaySinh,gioiTinh;
    private int giaHan;

    public ThanhVienHGDRequest() {
    }

    public ThanhVienHGDRequest(String cccd, String hoTen, String ngaySinh, String gioiTinh, int giaHan) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.giaHan = giaHan;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getGiaHan() {
        return giaHan;
    }

    public void setGiaHan(int giaHan) {
        this.giaHan = giaHan;
    }
}

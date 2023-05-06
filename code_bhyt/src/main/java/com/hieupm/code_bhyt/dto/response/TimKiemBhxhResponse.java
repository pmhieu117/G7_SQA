package com.hieupm.code_bhyt.dto.response;

public class TimKiemBhxhResponse {
    private String bhxh;
    private String cccd;
    private String hoTen;
    private String ngaySinh;
    private String tinhThanhPho;

    public TimKiemBhxhResponse() {
    }

    public TimKiemBhxhResponse(String bhxh, String cccd, String hoTen, String ngaySinh, String tinhThanhPho) {
        this.bhxh = bhxh;
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tinhThanhPho = tinhThanhPho;
    }

    public String getBhxh() {
        return bhxh;
    }

    public void setBhxh(String bhxh) {
        this.bhxh = bhxh;
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

    public String getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }
}

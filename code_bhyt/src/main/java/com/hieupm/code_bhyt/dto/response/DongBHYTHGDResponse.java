package com.hieupm.code_bhyt.dto.response;

public class DongBHYTHGDResponse {
    private String cccd;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private int giaHan;
    private String bhxh;
    private String bhyt;
    private String tuNgay;
    private String denNgay;
    private String tiLe;
    private double thanhTien;

    public DongBHYTHGDResponse() {
    }

    public DongBHYTHGDResponse(String cccd, String hoTen, String ngaySinh, String gioiTinh,
                               int giaHan, String bhxh, String bhyt, String tuNgay, String denNgay,
                               String tiLe, double thanhTien) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.giaHan = giaHan;
        this.bhxh = bhxh;
        this.bhyt = bhyt;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.tiLe = tiLe;
        this.thanhTien = thanhTien;
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

    public String getBhxh() {
        return bhxh;
    }

    public void setBhxh(String bhxh) {
        this.bhxh = bhxh;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }

    public String getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(String denNgay) {
        this.denNgay = denNgay;
    }

    public String getTiLe() {
        return tiLe;
    }

    public void setTiLe(String tiLe) {
        this.tiLe = tiLe;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}

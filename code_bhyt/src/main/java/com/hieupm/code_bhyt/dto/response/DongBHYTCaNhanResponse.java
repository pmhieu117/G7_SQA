package com.hieupm.code_bhyt.dto.response;

public class DongBHYTCaNhanResponse {
    private String bhyt;
    private String hoTen;
    private String tuNgay;
    private String denNgay;
    private String thanhTien;
    private String coQuanBHXH;

    public DongBHYTCaNhanResponse() {
    }

    public DongBHYTCaNhanResponse(String bhyt, String hoTen, String tuNgay, String denNgay, String thanhTien, String coQuanBHXH) {
        this.bhyt = bhyt;
        this.hoTen = hoTen;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.thanhTien = thanhTien;
        this.coQuanBHXH = coQuanBHXH;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getCoQuanBHXH() {
        return coQuanBHXH;
    }

    public void setCoQuanBHXH(String coQuanBHXH) {
        this.coQuanBHXH = coQuanBHXH;
    }
}

package com.hieupm.code_bhyt.dto.response;

import java.util.List;

public class ThongTinTaiKhoanResponse {
    private String hoTen;
    private String bhxh;
    private String cccd;
    private String tinhThanhPho;
    private String quanHuyen;
    private String phuongXa;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String imgChanDung;
    private String imgCccdTruoc;
    private String imgCccdSau;
    private String imgGks;
    private List<ThanhVienHGD> thanhVienHGD;

    public ThongTinTaiKhoanResponse() {
    }

    public ThongTinTaiKhoanResponse(String hoTen, String bhxh, String cccd, String tinhThanhPho,
                                    String quanHuyen, String phuongXa, String diaChi, String email,
                                    String soDienThoai, List<ThanhVienHGD> thanhVienHGD) {
        this.hoTen = hoTen;
        this.bhxh = bhxh;
        this.cccd = cccd;
        this.tinhThanhPho = tinhThanhPho;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.thanhVienHGD = thanhVienHGD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<ThanhVienHGD> getThanhVienHGD() {
        return thanhVienHGD;
    }

    public void setThanhVienHGD(List<ThanhVienHGD> thanhVienHGD) {
        this.thanhVienHGD = thanhVienHGD;
    }

    public String getImgChanDung() {
        return imgChanDung;
    }

    public void setImgChanDung(String imgChanDung) {
        this.imgChanDung = imgChanDung;
    }

    public String getImgCccdTruoc() {
        return imgCccdTruoc;
    }

    public void setImgCccdTruoc(String imgCccdTruoc) {
        this.imgCccdTruoc = imgCccdTruoc;
    }

    public String getImgCccdSau() {
        return imgCccdSau;
    }

    public void setImgCccdSau(String imgCccdSau) {
        this.imgCccdSau = imgCccdSau;
    }

    public String getImgGks() {
        return imgGks;
    }

    public void setImgGks(String imgGks) {
        this.imgGks = imgGks;
    }
}

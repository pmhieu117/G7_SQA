package com.hieupm.code_bhyt.dto.request;

import java.util.Date;
import java.util.Set;

public class AddUserRequest {
    private long id;
    private String addressGks;
    private String cccd;
    private String diaChi;
    private String gioiTinh;
    private String hoTen;
    private String ngaySinh;
    private String tinhThanhPho;
    private String quanHuyen;
    private String phuongXa;
    private String quanHeChuHo;
    private String bhxh;
    private String hoGiaDinh;
    private Set<String> role;

    public AddUserRequest() {
    }

    public AddUserRequest(String addressGks, String cccd, String diaChi,
                          String gioiTinh, String hoTen, String ngaySinh,
                          String tinhThanhPho, String quanHuyen, String phuongXa,
                          String quanHeChuHo, String bhxh, String hoGiaDinh) {
        this.addressGks = addressGks;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tinhThanhPho = tinhThanhPho;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.quanHeChuHo = quanHeChuHo;
        this.bhxh = bhxh;
        this.hoGiaDinh = hoGiaDinh;
    }

    public AddUserRequest(long id, String addressGks, String cccd, String diaChi, String gioiTinh,
                          String hoTen, String ngaySinh, String tinhThanhPho, String quanHuyen,
                          String phuongXa, String quanHeChuHo, String bhxh, String hoGiaDinh, Set<String> role) {
        this.id = id;
        this.addressGks = addressGks;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tinhThanhPho = tinhThanhPho;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.quanHeChuHo = quanHeChuHo;
        this.bhxh = bhxh;
        this.hoGiaDinh = hoGiaDinh;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressGks() {
        return addressGks;
    }

    public void setAddressGks(String addressGks) {
        this.addressGks = addressGks;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getQuanHeChuHo() {
        return quanHeChuHo;
    }

    public void setQuanHeChuHo(String quanHeChuHo) {
        this.quanHeChuHo = quanHeChuHo;
    }

    public String getBhxh() {
        return bhxh;
    }

    public void setBhxh(String bhxh) {
        this.bhxh = bhxh;
    }

    public String getHoGiaDinh() {
        return hoGiaDinh;
    }

    public void setHoGiaDinh(String hoGiaDinh) {
        this.hoGiaDinh = hoGiaDinh;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}

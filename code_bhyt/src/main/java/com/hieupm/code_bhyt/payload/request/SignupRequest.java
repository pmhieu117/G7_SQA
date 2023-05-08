package com.hieupm.code_bhyt.payload.request;

import java.util.Set;

public class SignupRequest {
  private String username,hoTen,cccd,tinhThanhPho,quanHuyen,phuongXa,diaChi,
          soDienThoai,email,imgChanDung,cccdTruoc,cccdSau,imgGks,chiTietCoQuanBHXH;
  private String password, xacThuc;
  //private Set<String> role;

  public SignupRequest() {
  }

  public SignupRequest(String username, String hoTen, String cccd, String tinhThanhPho, String quanHuyen, String phuongXa, String diaChi, String soDienThoai, String email, String imgChanDung, String cccdTruoc, String cccdSau, String imgGks, String chiTietCoQuanBHXH) {
    this.username = username;
    this.hoTen = hoTen;
    this.cccd = cccd;
    this.tinhThanhPho = tinhThanhPho;
    this.quanHuyen = quanHuyen;
    this.phuongXa = phuongXa;
    this.diaChi = diaChi;
    this.soDienThoai = soDienThoai;
    this.email = email;
    this.imgChanDung = imgChanDung;
    this.cccdTruoc = cccdTruoc;
    this.cccdSau = cccdSau;
    this.imgGks = imgGks;
    this.chiTietCoQuanBHXH = chiTietCoQuanBHXH;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getHoTen() {
    return hoTen;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
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

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImgChanDung() {
    return imgChanDung;
  }

  public void setImgChanDung(String imgChanDung) {
    this.imgChanDung = imgChanDung;
  }

  public String getCccdTruoc() {
    return cccdTruoc;
  }

  public void setCccdTruoc(String cccdTruoc) {
    this.cccdTruoc = cccdTruoc;
  }

  public String getCccdSau() {
    return cccdSau;
  }

  public void setCccdSau(String cccdSau) {
    this.cccdSau = cccdSau;
  }

  public String getImgGks() {
    return imgGks;
  }

  public void setImgGks(String imgGks) {
    this.imgGks = imgGks;
  }

  public String getChiTietCoQuanBHXH() {
    return chiTietCoQuanBHXH;
  }

  public void setChiTietCoQuanBHXH(String chiTietCoQuanBHXH) {
    this.chiTietCoQuanBHXH = chiTietCoQuanBHXH;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getXacThuc() {
    return xacThuc;
  }

  public void setXacThuc(String xacThuc) {
    this.xacThuc = xacThuc;
  }
  //  public Set<String> getRole() {
//    return role;
//  }
//
//  public void setRole(Set<String> role) {
//    this.role = role;
//  }
}

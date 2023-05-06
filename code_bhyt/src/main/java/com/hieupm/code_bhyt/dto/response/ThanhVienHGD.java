package com.hieupm.code_bhyt.dto.response;

public class ThanhVienHGD {
    private int stt;
    private String bhxh;
    private String hoTen;
    private String mqh;

    public ThanhVienHGD() {
    }

    public ThanhVienHGD(int stt, String bhxh, String hoTen, String mqh) {
        this.stt = stt;
        this.bhxh = bhxh;
        this.hoTen = hoTen;
        this.mqh = mqh;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getBhxh() {
        return bhxh;
    }

    public void setBhxh(String bhxh) {
        this.bhxh = bhxh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMqh() {
        return mqh;
    }

    public void setMqh(String mqh) {
        this.mqh = mqh;
    }
}

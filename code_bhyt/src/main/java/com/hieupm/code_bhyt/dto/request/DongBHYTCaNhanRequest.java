package com.hieupm.code_bhyt.dto.request;

public class DongBHYTCaNhanRequest {
    private String bhyt;
    private int giaHan;

    public DongBHYTCaNhanRequest() {
    }

    public DongBHYTCaNhanRequest(String bhyt, int giaHan) {
        this.bhyt = bhyt;
        this.giaHan = giaHan;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public int getGiaHan() {
        return giaHan;
    }

    public void setGiaHan(int giaHan) {
        this.giaHan = giaHan;
    }
}

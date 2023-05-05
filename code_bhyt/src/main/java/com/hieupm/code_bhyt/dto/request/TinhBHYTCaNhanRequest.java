package com.hieupm.code_bhyt.dto.request;

public class TinhBHYTCaNhanRequest {
    private String thoiGianGiaHan;
    private String bhyt;
    private int giaHan;

    public TinhBHYTCaNhanRequest() {
    }

    public TinhBHYTCaNhanRequest(String thoiGianGiaHan, String bhyt, int giaHan) {
        this.thoiGianGiaHan = thoiGianGiaHan;
        this.bhyt = bhyt;
        this.giaHan = giaHan;
    }

    public String getThoiGianGiaHan() {
        return thoiGianGiaHan;
    }

    public void setThoiGianGiaHan(String thoiGianGiaHan) {
        this.thoiGianGiaHan = thoiGianGiaHan;
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

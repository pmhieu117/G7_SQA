package com.hieupm.code_bhyt.dto.request;

public class KhaiBaoBHYTRequest {
    private String bhyt;
    private String diaChiCapBhyt;
    private String kcbBhyt;
    private String imgBhyt;

    public KhaiBaoBHYTRequest() {
    }

    public KhaiBaoBHYTRequest(String bhyt, String diaChiCapBhyt, String kcbBhyt, String imgBhyt) {
        this.bhyt = bhyt;
        this.diaChiCapBhyt = diaChiCapBhyt;
        this.kcbBhyt = kcbBhyt;
        this.imgBhyt = imgBhyt;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public String getDiaChiCapBhyt() {
        return diaChiCapBhyt;
    }

    public void setDiaChiCapBhyt(String diaChiCapBhyt) {
        this.diaChiCapBhyt = diaChiCapBhyt;
    }

    public String getKcbBhyt() {
        return kcbBhyt;
    }

    public void setKcbBhyt(String kcbBhyt) {
        this.kcbBhyt = kcbBhyt;
    }

    public String getImgBhyt() {
        return imgBhyt;
    }

    public void setImgBhyt(String imgBhyt) {
        this.imgBhyt = imgBhyt;
    }
}

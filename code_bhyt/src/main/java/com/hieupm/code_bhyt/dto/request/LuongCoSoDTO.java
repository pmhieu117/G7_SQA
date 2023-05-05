package com.hieupm.code_bhyt.dto.request;

import java.util.Date;

public class LuongCoSoDTO {
    private long id;
    private double mucLuongCoSo;
    private String ngayBatDau;

    public LuongCoSoDTO() {
    }

    public LuongCoSoDTO(double mucLuongCoSo, String ngayBatDau) {
        this.mucLuongCoSo = mucLuongCoSo;
        this.ngayBatDau = ngayBatDau;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMucLuongCoSo() {
        return mucLuongCoSo;
    }

    public void setMucLuongCoSo(double mucLuongCoSo) {
        this.mucLuongCoSo = mucLuongCoSo;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
}

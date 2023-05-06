package com.hieupm.code_bhyt.dto.request;

public class DoiMatKhauRequest {
    private String matKhauCu;
    private String matKhauMoi;
    private String xacThuc;

    public DoiMatKhauRequest() {
    }

    public DoiMatKhauRequest(String matKhauCu, String matKhauMoi, String xacThuc) {
        this.matKhauCu = matKhauCu;
        this.matKhauMoi = matKhauMoi;
        this.xacThuc = xacThuc;
    }

    public String getMatKhauCu() {
        return matKhauCu;
    }

    public void setMatKhauCu(String matKhauCu) {
        this.matKhauCu = matKhauCu;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public String getXacThuc() {
        return xacThuc;
    }

    public void setXacThuc(String xacThuc) {
        this.xacThuc = xacThuc;
    }
}

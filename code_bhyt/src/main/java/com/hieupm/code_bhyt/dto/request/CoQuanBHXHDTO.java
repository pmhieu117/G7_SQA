package com.hieupm.code_bhyt.dto.request;

public class CoQuanBHXHDTO {
    private String code;
    private String diaPhuong;

    public CoQuanBHXHDTO() {
    }

    public CoQuanBHXHDTO(String code, String diaPhuong) {
        this.code = code;
        this.diaPhuong = diaPhuong;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiaPhuong() {
        return diaPhuong;
    }

    public void setDiaPhuong(String diaPhuong) {
        this.diaPhuong = diaPhuong;
    }
}

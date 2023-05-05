package com.hieupm.code_bhyt.dto.request;

import java.util.List;

public class DongBHYTHGDRequest {
    private ChuHoDTO chuHoDTO;
    private List<ThanhVienHGDRequest> thanhVienHGDRequestList;

    public DongBHYTHGDRequest() {
    }

    public DongBHYTHGDRequest(ChuHoDTO chuHoDTO, List<ThanhVienHGDRequest> thanhVienHGDRequestList) {
        this.chuHoDTO = chuHoDTO;
        this.thanhVienHGDRequestList = thanhVienHGDRequestList;
    }

    public ChuHoDTO getChuHoDTO() {
        return chuHoDTO;
    }

    public void setChuHoDTO(ChuHoDTO chuHoDTO) {
        this.chuHoDTO = chuHoDTO;
    }

    public List<ThanhVienHGDRequest> getThanhVienHGDRequestList() {
        return thanhVienHGDRequestList;
    }

    public void setThanhVienHGDRequestList(List<ThanhVienHGDRequest> thanhVienHGDRequestList) {
        this.thanhVienHGDRequestList = thanhVienHGDRequestList;
    }
}

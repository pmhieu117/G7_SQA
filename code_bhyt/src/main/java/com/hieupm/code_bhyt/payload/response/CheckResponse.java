package com.hieupm.code_bhyt.payload.response;

import java.util.List;

public class CheckResponse {
    private String hoTen;
    private String username;
    private List<String> roles;
    private String status;

    public CheckResponse() {
    }

    public CheckResponse(String hoTen, String username, List<String> roles, String status) {
        this.hoTen = hoTen;
        this.username = username;
        this.roles = roles;
        this.status = status;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

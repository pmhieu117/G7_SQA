package com.hieupm.code_bhyt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "luong_co_so")
public class LuongCoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "muc_luong_co_so")
    private double mucLuongCoSo;

    @OneToMany(mappedBy = "luongCoSo")
    private Set<HoaDon> hoaDonSet;

    public LuongCoSo(String ngayBatDau, double mucLuongCoSo) {
        try {
            this.ngayBatDau = new SimpleDateFormat("dd/MM/yyyy").parse(ngayBatDau);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.mucLuongCoSo = mucLuongCoSo;
    }
}

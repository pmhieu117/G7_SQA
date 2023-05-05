package com.hieupm.code_bhyt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @ManyToOne
    @JoinColumn(name = "nguoi_thanh_toan")
    private User nguoiThanhToan;

    @Column(name = "tong_tien")
    private double tongTien;

    @OneToMany(mappedBy = "hoaDon")
    private Set<ChiTietHoaDon> chiTietHoaDonSet;

    @ManyToOne
    @JoinColumn(name = "id_luong_co_so")
    private LuongCoSo luongCoSo;
}

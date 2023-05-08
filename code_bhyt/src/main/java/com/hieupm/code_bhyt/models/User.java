package com.hieupm.code_bhyt.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 10)
  @Column(name = "bhxh")
  private String username;

  //@NotBlank
  @Column(length = 50)
  @Email
  private String email;

  //@NotBlank
  @Column(length = 255)
  private String password;

  @NotBlank
  @Column(length = 12)
  private String cccd;

  @ManyToOne
  @JoinColumn(name = "code_doi_tuong_bhyt")
  private DoiTuongBHYT doiTuongBHYT;

  @Column(name = "muc_huong",length = 1)
  private String mucHuong;

  @Column(name = "so_dien_thoai",length = 11)
  private String soDienThoai;

  @NotBlank
  @Column(name = "ho_ten",length = 100)
  private String hoTen;

  @NotBlank
  @Column(name = "ngay_sinh")
  private String ngaySinh;

  @NotBlank
  @Column(name = "tinh_thanh_pho",length = 50)
  private String tinhThanhPho;

  @NotBlank
  @Column(name = "quan_huyen",length = 50)
  private String quanHuyen;

  @NotBlank
  @Column(name = "phuong_xa",length = 50)
  private String phuongXa;

  @NotBlank
  @Column(name = "dia_chi",length = 255)
  private String diaChi;

  @Column(name = "img_chan_dung")
  private String imgChanDung;

  @Column(name = "cccd_truoc")
  private String cccdTruoc;

  @Column(name = "cccd_sau")
  private String cccdSau;

  @Column(name = "img_bhyt")
  private String imgBhyt;

  @NotBlank
  @Column(name = "gioi_tinh",length = 20)
  private String gioiTinh;

  @ManyToOne
  @JoinColumn(name = "code_ct_co_quan_bhxh")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private ChiTietCoQuanBHXH chiTietCoQuanBHXH;

  @OneToOne(mappedBy = "chuHo")
  private HoGiaDinh chuHoGiaDinh;

  @ManyToOne
  @JoinColumn(name = "ho_gia_dinh")
  private HoGiaDinh hoGiaDinh;

  @Column(name = "quan_he_chu_ho")
  private String quanHeChuHo;
  @Column(name = "dia_chi_cap_bhyt")
  private String diaChiBhyt;
  @Column(name = "kcb_bhyt")
  private String diaChiKcb;

  @Column(name = "bhyt", length = 15)
  private String bhyt;

  @ManyToOne
  @JoinColumn(name = "code_tinhTP")
  private CoQuanBHXH coQuanBHXH;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "nguoiThanhToan")
  private Set<HoaDon> hoaDonSet;

  @OneToMany(mappedBy = "nguoiThuHuong")
  private Set<ChiTietHoaDon> chiTietHoaDonSet;

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User(String username, String cccd, String hoTen, String ngaySinh,
              String tinhThanhPho, String quanHuyen, String phuongXa, String diaChi,
              String gioiTinh, HoGiaDinh hoGiaDinh, String quanHeChuHo, String diaChiBhyt) {
    this.username = username;
    this.cccd = cccd;
    this.hoTen = hoTen;
    this.ngaySinh = ngaySinh;
    this.tinhThanhPho = tinhThanhPho;
    this.quanHuyen = quanHuyen;
    this.phuongXa = phuongXa;
    this.diaChi = diaChi;
    this.gioiTinh = gioiTinh;
    this.hoGiaDinh = hoGiaDinh;
    this.quanHeChuHo = quanHeChuHo;
    this.diaChiBhyt = diaChiBhyt;
  }
}

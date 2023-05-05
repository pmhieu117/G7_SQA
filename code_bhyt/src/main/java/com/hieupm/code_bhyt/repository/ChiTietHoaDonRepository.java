package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon,Long> {
    @Query("SELECT c.ngayKetThuc FROM ChiTietHoaDon c WHERE c.nguoiThuHuong.bhyt = :bhyt ORDER BY c.ngayKetThuc DESC")
    Date findNgayKetThucByBHYTNguoiThuhuong(@Param("bhyt") String bhyt);
}

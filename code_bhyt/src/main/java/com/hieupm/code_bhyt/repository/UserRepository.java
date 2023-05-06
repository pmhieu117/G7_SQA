package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.HoGiaDinh;
import com.hieupm.code_bhyt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Boolean existsBySoDienThoai(String soDienThoai);

  Optional<User> findByCccdAndHoTenAndNgaySinhAndGioiTinh(String cccd, String hoTen, String ngaySinh, String gioiTinh);

  Optional<User> findByCccd(String cccd);

  Optional<User> findByBhyt(String bhyt);

  @Query("SELECT u FROM User u WHERE u.hoGiaDinh.code = :maHGD")
  List<User> findByMaHoGiaDinh(@Param("maHGD") String maHGD);

  List<User> findUserByTinhThanhPhoAndHoTenAndNgaySinh(String tinhThanhPho, String hoTen, String ngaySinh);

  List<User> findUserByHoGiaDinh(HoGiaDinh hoGiaDinh);
}

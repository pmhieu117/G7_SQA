package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.LuongCoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface LuongCoSoRepository extends JpaRepository<LuongCoSo, Long> {
    Optional<LuongCoSo> findById(Long id);

    @Query("SELECT l.mucLuongCoSo FROM LuongCoSo l WHERE l.ngayBatDau <= :now ORDER BY l.ngayBatDau DESC")
    Double findMucLuongCoSoByNgayGanNhat(@Param("now") Date now);

}

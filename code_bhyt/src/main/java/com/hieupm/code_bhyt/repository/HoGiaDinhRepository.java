package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.HoGiaDinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoGiaDinhRepository extends JpaRepository<HoGiaDinh,String> {
    Optional<HoGiaDinh> findByCode(String code);
}

package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.DoiTuongBHYT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoiTuongBHYTRepository extends JpaRepository<DoiTuongBHYT,String> {
    @Override
    Optional<DoiTuongBHYT> findById(String s);

}

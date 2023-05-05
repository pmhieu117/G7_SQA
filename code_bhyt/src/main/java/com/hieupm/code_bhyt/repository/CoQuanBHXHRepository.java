package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.CoQuanBHXH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoQuanBHXHRepository extends JpaRepository<CoQuanBHXH,String> {

    Optional<CoQuanBHXH> findByCode(String code);
}

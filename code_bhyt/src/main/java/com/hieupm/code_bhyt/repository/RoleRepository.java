package com.hieupm.code_bhyt.repository;

import com.hieupm.code_bhyt.models.ERole;
import com.hieupm.code_bhyt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}

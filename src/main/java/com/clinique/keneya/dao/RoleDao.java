package com.clinique.keneya.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinique.keneya.entity.Role;
@Repository
public interface RoleDao extends JpaRepository<Role, Long>{

	boolean existsByRole(String role);

	Role findByRole(String roleName);

}

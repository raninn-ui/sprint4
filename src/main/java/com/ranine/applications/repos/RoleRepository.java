package com.ranine.applications.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranine.applications.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> { 
	Role findByRole(String role); 

}

package com.ranine.applications.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranine.applications.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { 
	User findByUsername (String username);

}

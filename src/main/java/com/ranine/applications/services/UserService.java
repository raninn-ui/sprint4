package com.ranine.applications.services;

import com.ranine.applications.entities.Role;
import com.ranine.applications.entities.User;

public interface UserService {
	void deleteAllusers(); 
	void deleteAllRoles(); 
	User saveUser(User user); 
	User findUserByUsername (String username); 
	Role addRole(Role role); 
	User addRoleToUser(String username, String rolename); 
}

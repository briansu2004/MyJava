package com.sutek.userservice.service;

import com.sutek.userservice.domain.Role;
import com.sutek.userservice.domain.User;

import java.util.List;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}

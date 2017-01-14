package com.security.dao;

import java.util.List;

public interface Users {

	void addUser(Users user);

	void deleteUser(Users user);

	List<Users> getAllUsers();

	Users getUserByUsername(String username);
}

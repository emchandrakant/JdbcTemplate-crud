package com.ms.dao;

import java.util.List;

import com.ms.entity.User;

public interface UserDao {
	User saveUser(User user);
	User updateUser(User user);
	User getById(int id);
	String deleteById(int id);
	List<User> allUsers();
}

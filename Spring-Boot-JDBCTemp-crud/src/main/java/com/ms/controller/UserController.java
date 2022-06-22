package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dao.UserDao;
import com.ms.entity.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userDao.saveUser(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userDao.updateUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userDao.getById(id);
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userDao.allUsers();
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		
		return userDao.deleteById(id);
	}
}

package com.example.userService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userService.dao.UserDao;
import com.example.userService.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
public Optional<User> findUserById(int id) {
	return userDao.findById(id);
	
}
}

package com.example.userService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userService.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}

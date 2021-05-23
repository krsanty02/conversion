package com.example.micro1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro1.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}

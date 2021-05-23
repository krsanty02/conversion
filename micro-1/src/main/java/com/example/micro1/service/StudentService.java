package com.example.micro1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro1.dao.StudentDao;
import com.example.micro1.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public Optional<Student> findStudentById(int id) {

		return studentDao.findById(id);
	}

}

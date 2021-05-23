package com.example.micro1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro1.entity.Student;
import com.example.micro1.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/getStudent/{id}")
	public ResponseEntity<Optional<Student>> findUser(@PathVariable("id") int id) {
		Optional<Student> student = studentService.findStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(student);

	}
}

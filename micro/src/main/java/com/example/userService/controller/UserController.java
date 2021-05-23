package com.example.userService.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.userService.entity.Student;
import com.example.userService.entity.User;
import com.example.userService.proxy.UserProxy;
import com.example.userService.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserProxy proxy;

	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<User> findUser(@PathVariable("id") int id) {
		System.out.println("In Usr Controller rest template");
		Optional<User> user = userService.findUserById(id);
		System.out.println(user.get().getEmail());
		User user1 = new User();
		// List student =
		// this.restTemplate.getForObject("http://localhost:9091/getStudent/1",
		// List.class);

ResponseEntity<Student> st= this.restTemplate.getForEntity("http://localhost:9091/getStudent/1", Student.class);

		if (user.isPresent()) {
			user1.setEmail(user.get().getEmail());
			user1.setId(user.get().getId());
			user1.setPassword(user.get().getPassword());
			
		}
		ArrayList<Student> student=new ArrayList<Student>();
		student.add(st.getBody());
		System.out.println(student.get(0).getId());
		user1.setStudents(student);

		return ResponseEntity.status(HttpStatus.OK).body(user1);

	}
	@GetMapping(value = "/getUser/feign/{id}")
	public ResponseEntity<User> findUserfeign(@PathVariable("id") int id) {
		System.out.println("In Usr Controller feign");
		Optional<User> user = userService.findUserById(id);
		System.out.println(user.get().getEmail());
		User user1 = new User();
		// List student =
		// this.restTemplate.getForObject("http://localhost:9091/getStudent/1",
		// List.class);

Student st=proxy.findUser(id);
ArrayList<Student> student=new ArrayList<Student>();
student.add(st);
		if (user.isPresent()) {
			user1.setEmail(user.get().getEmail());
			user1.setId(user.get().getId());
			user1.setPassword(user.get().getPassword());
			user1.setStudents(student);
			
		}
		
		System.out.println(student.get(0).getId());
		user1.setStudents(student);

		return ResponseEntity.status(HttpStatus.OK).body(user1);

	}
}

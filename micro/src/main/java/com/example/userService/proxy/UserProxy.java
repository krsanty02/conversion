package com.example.userService.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userService.entity.Student;
@FeignClient(name="Student",url="localhost:9091")
public interface UserProxy {
	@GetMapping(value = "/getStudent/{id}")
	public Student findUser(@PathVariable("id") int id) ;
}

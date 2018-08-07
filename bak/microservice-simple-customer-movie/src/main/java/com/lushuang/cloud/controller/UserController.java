package com.lushuang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lushuang.cloud.entity.User;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTempldate;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable("id") long id) {
		return restTempldate.getForObject("http://localhost:8080/simple/" + id, User.class);
	}
	
}

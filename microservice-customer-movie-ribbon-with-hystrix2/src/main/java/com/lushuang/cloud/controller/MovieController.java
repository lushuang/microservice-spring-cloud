package com.lushuang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lushuang.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTempldate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public User findById(@PathVariable("id") long id) {
		return restTempldate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	public User findByIdFallback(long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}
}

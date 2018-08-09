package com.lushuang.cloud.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lushuang.cloud.entity.User;
import com.netflix.loadbalancer.ILoadBalancer;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTempldate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable("id") long id) {
		return restTempldate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
		System.out.println("111:" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
		
		ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("222:" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
		
		System.out.println();
		
		return "1";
	}
	
	@GetMapping("/list-all")
	public List<User> listAll() {
		
		// wrong
//		List<User> lists = this.restTempldate.getForObject("http://microservice-provider-user/list-all/", List.class);
//		return lists;
		
		// right
		User[] userArrays = this.restTempldate.getForObject("http://microservice-provider-user/list-all/", User[].class);
		List<User> lists = Arrays.asList(userArrays);
		return lists;
		
	}
	
}

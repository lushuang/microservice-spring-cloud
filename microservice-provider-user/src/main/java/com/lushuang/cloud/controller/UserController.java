package com.lushuang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lushuang.cloud.dao.UserRepository;
import com.lushuang.cloud.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EurekaClient discoveryClient;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
	
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}

}

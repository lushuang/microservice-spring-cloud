package com.lushuang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lushuang.cloud.entity.User;
import com.lushuang.cloud.feign.FeignClient2;
import com.lushuang.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private FeignClient2 feignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable("id") long id) {
		return userFeignClient.findById(id);
	}

	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
		return feignClient.findServiceInfoFromEurekaByServiceName(serviceName);
	}
}

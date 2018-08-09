package com.lushuang.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lushuang.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	// 两个坑，1 @GettingMapping 不支持， 2 @PathVariable value值需要设置
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);

	@RequestMapping(value = "/test-post", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	// 请求不会成功，只要参数是复杂对象，即使制定了GET方法，feign依然会以POST方法进行发送请求。
	@RequestMapping(value = "/test-get", method = RequestMethod.GET)
	public User getUser(User user);
}

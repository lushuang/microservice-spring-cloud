package com.lushuang.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.lushuang.cloud.entity.User;
import com.lushuang.config.FeignConfiguration;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id")  Long id);
}

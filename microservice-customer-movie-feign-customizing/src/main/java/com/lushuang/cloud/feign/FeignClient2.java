package com.lushuang.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lushuang.config.FeignConfiguration2;

@FeignClient(name = "eurekaUrl", url = "http://localhost:8761/", configuration = FeignConfiguration2.class)
public interface FeignClient2 {

	@RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);

}

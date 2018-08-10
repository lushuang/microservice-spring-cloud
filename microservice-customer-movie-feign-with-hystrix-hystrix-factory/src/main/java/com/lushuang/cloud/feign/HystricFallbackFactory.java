package com.lushuang.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lushuang.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystricFallbackFactory implements FallbackFactory<UserFeignClient> {
	
	private static final Logger logger = LoggerFactory.getLogger(HystricFallbackFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		HystricFallbackFactory.logger.info("fallback reason was: {}" + cause.getMessage());
		
		return new UserFeignClientWithFallBackFactory() {

			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}
		};
	}
}

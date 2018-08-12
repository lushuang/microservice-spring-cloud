package com.lushuang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigServerAuthcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigServerAuthcApplication.class, args);
	}
}

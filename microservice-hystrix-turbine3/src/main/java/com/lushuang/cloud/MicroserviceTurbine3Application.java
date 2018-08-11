package com.lushuang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class MicroserviceTurbine3Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTurbine3Application.class, args);
	}
}

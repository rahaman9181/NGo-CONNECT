package com.ngoconnect.ngoserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NgoServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoServiceRegistryApplication.class, args);
	}

}

package com.event.discoveryserver.EventDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EventDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventDiscoveryApplication.class, args);
	}

}

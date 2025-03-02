package com.spring.meter_converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MeterConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterConverterApplication.class, args);
	}

}

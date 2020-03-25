package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@SpringBootApplication
@EnableDiscoveryClient
public class CalculaterServiceCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculaterServiceCloudApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSampler() {
	    return Sampler.ALWAYS_SAMPLE;
	}
}

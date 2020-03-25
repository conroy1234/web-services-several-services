package org.calculater.currencyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EnableFeignClients("org.calculater.currencyService")
@SpringBootApplication
public class CurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyServiceApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSampler() {
	    return Sampler.ALWAYS_SAMPLE;
	}

}

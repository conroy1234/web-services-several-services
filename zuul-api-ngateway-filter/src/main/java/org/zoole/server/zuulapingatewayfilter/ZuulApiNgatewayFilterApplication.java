package org.zoole.server.zuulapingatewayfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import brave.sampler.Sampler;
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApiNgatewayFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiNgatewayFilterApplication.class, args);
	}

	@Bean
	public Sampler alwaysSampler() {
	    return Sampler.ALWAYS_SAMPLE;
	}
}

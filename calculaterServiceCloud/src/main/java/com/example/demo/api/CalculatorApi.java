package com.example.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CalculatorServiceBean;


@RestController
public class CalculatorApi {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/calculater-service/calculate/from/{from}/to/{to}/return")
	public ResponseEntity<CalculatorServiceBean> calculator(@PathVariable String from, @PathVariable String to){
		CalculatorServiceBean bean = new CalculatorServiceBean(1,from,to,180,2000);
		bean.setPort(environment.getProperty("local.server.port"));
		System.out.println("the bean==>"+bean);
		return new ResponseEntity(bean,HttpStatus.OK);
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}

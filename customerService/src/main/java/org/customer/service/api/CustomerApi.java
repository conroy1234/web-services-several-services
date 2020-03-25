package org.customer.service.api;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.customer.service.bean.CustomerServiceBean;
import org.customer.service.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApi {
	
	@Autowired
	Environment env;
	
	@GetMapping("/customer-service/name/{name}/adderss/{address}/return")
	public ResponseEntity<CustomerServiceBean> customerBean(@PathVariable String name, @PathVariable String address ) throws UnsupportedEncodingException{
		CustomerServiceBean customerServiceBean = new CustomerServiceBean(1,name,address);
		try {
		
	byte[] uuid=UUID.randomUUID().toString().getBytes("UTF-8");
		customerServiceBean.setPort(env.getProperty("local.server.port"));
		customerServiceBean.setUuid(uuid);
		}catch(CustomerException ex) {
			ex.getMessage();
		}
		return new ResponseEntity<>(customerServiceBean,HttpStatus.OK);
	}

}

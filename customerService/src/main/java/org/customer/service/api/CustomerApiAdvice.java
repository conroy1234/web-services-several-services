package org.customer.service.api;

import java.util.Date;

import org.customer.service.bean.CustomerExceptionBean;
import org.customer.service.exception.CustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerApiAdvice {
	
	@ExceptionHandler(value=CustomerException.class)
	public ResponseEntity<Object> handleException(CustomerException ex){
		CustomerExceptionBean bean = new CustomerExceptionBean(ex.getMessage(),new Date());
		return new ResponseEntity(bean,HttpStatus.EXPECTATION_FAILED);
		
	}

}

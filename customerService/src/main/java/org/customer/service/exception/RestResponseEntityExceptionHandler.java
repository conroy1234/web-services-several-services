package org.customer.service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	public ResponseEntity<Object> handleException(IllegalArgumentException ex, WebRequest request){
		return handleExceptionInternal(ex,"body of the request",new HttpHeaders(),HttpStatus.CONFLICT,request);
		
	}

}

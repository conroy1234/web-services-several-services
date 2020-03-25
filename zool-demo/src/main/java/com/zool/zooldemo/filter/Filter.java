package com.zool.zooldemo.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class Filter extends ZuulFilter{

	Logger logger = LoggerFactory.getLogger(Filter.class);
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	HttpServletRequest request=	RequestContext.getCurrentContext().getRequest();
	logger.info("Request ->{} " + request.getContentType() + " Request URL ----->{} " + request.getRequestURL().toString()
			+ "request method -> {}" + request.getMethod());

		return null;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
	
		return 1;
	}

}

package org.zoole.server.zuulapingatewayfilter.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.zoole.server.zuulapingatewayfilter.exception.MyResourceNotFoundException;
import org.zoole.server.zuulapingatewayfilter.exception.RestResponseEntityExceptionHandler;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class GatewayFilter extends ZuulFilter {

	private Logger loffer = LoggerFactory.getLogger(GatewayFilter.class);
	private static final boolean SHOULD_FILTER = true;
	private static final int FILTER_ORDER = 1;

	

	@Override
	public boolean shouldFilter() {

		return SHOULD_FILTER;
	}

	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		
		System.out.println("Request ->{} " + request + " Request URL ->{} " + request.getRequestURL().toString()
				+ "request method -> {}" + request.getMethod());
		return null;
	}

	@Override
	public String filterType() {

		return preFilter().filterType();
	}

	@Override
	public int filterOrder() {

		return FILTER_ORDER;
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}

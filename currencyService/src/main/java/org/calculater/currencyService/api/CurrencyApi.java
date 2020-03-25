package org.calculater.currencyService.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.calculater.currencyService.bean.CurrencyServiceBean;
import org.calculater.currencyService.bean.CustomerServiceBean;
import org.calculater.currencyService.proxi.CustomerServiceFeignProxi;
import org.calculater.currencyService.proxi.FainApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyApi {
	
	@Autowired
	FainApi fainApi;
	
	@Autowired
	CustomerServiceFeignProxi customerServiceFeignProxi;
	
	@GetMapping("/currency-service/from/{from}/to/{to}-live")
	public ResponseEntity<CurrencyServiceBean> calculator(@PathVariable String from, @PathVariable String to){
		Map<String,String> converted = new HashMap<>();
		converted.put("from",from);
		converted.put("to",to);
		ResponseEntity<CurrencyServiceBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8080//calculater-service/calculate/from/{from}/to/{to}/return", CurrencyServiceBean.class,converted);
		CurrencyServiceBean response = responseEntity.getBody();
		response.setTotal(response.getExchangeAmount()*response.getExchangeRate());
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	@GetMapping("/currency-service/from/{from}/to/{to}")
	public ResponseEntity<CurrencyServiceBean> calculatorFeign(@PathVariable String from, @PathVariable String to){
		HttpStatus status=HttpStatus.OK;
		CurrencyServiceBean response = fainApi.calculaterServiceApi(from, to);
		response.setTotal(response.getExchangeAmount()*response.getExchangeRate());
		System.out.println(response.toString());
		if(response.getPort().equals("8087")) {
			status=HttpStatus.ACCEPTED;
		}
		return new ResponseEntity(response,status);
	}
	
	@GetMapping("/customer-service/name/{name}/address/{address}/load")
	public ResponseEntity<CustomerServiceBean> customerService(@PathVariable String name, @PathVariable String address){
		HttpStatus status=HttpStatus.OK;
		CustomerServiceBean response = customerServiceFeignProxi.customerServiceApi(name, address);
		response.setUuid(UUID.randomUUID().toString());
		System.out.println("-->{}"+response);
		
		return new ResponseEntity(response,status);
	}
	@GetMapping("/show")
	public String show() {
		return "show";
		
	}

}

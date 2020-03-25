package org.calculater.currencyService.proxi;

import org.calculater.currencyService.bean.CurrencyServiceBean;
import org.calculater.currencyService.bean.CustomerServiceBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//url is not needed because ribbon is now being used
//@FeignClient(name="calculationServiceCloud", url="http://localhost:8080")
@FeignClient(name="customerService")
@RibbonClient(name="customerService")
public interface CustomerServiceFeignProxi {
	
	@GetMapping("/customer-service/name/{name}/adderss/{address}/return")
	public CustomerServiceBean customerServiceApi(@PathVariable("name") String from, @PathVariable("address") String to);
	
	
}

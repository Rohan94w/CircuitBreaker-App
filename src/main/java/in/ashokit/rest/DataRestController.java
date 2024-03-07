package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {

	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB",name = "AshokIt")
	public String getData() {
		
		System.out.println("Redis Method is called");
		
		int i = 10/0;
		
		return "redis data send to ur email";
	}
	
	public String etDataFromDB(Throwable t) {
		
		System.out.println("DB Method is called");
		return "DB data send to ur email";
	}
}

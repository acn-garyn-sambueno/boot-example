package com.boot.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.Greeting;


@RestController
public class HomeController {
  
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

 
	
	@RequestMapping("/")
	public String home() {
		return "Das Boot, reporting for duty!";
	}

	 @RequestMapping("/greeting")
	  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	      return new Greeting(counter.incrementAndGet(),
	                          String.format(template, name));
	  }
}

package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController 
{	
	// expose "/" that return "Hello World"
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World ! Time on Server is : "+LocalDateTime.now();
		
	}
	
	// expose a new end point for "workout"
	
	@GetMapping("/workout")
	public String getDailyWorkOut()
	{
		return "Run a Hard 5K!  :) :) :)";
	}
	
	@GetMapping("/work")
	public String getDailyWork()
	{
		return "Run a Hard K!  :) :) :)";
	}
	
	
	
	

}

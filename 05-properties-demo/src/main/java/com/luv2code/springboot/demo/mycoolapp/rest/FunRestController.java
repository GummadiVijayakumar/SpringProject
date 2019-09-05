package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController 
{	
	
	// inject values from application.properties file
	
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	// expose new endpoint for "teaminfo"
	
	@GetMapping("teaminfo")
	public String teamInfo()
	{
		return "My coach name is : "+ coachName + ",   My team Name is : "+teamName;
	}
	
	

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

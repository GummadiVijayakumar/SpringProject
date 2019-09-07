package com.lu2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach 
{
	
	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(FortuneService theFortuneService)
	{
		fortuneService=	theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() 
	{
		
		return "Tennis Coach Says: Practice your BackHand Volley ";
	
	}

	@Override
	public String getDailyFortune()
	{
		
		return fortuneService.getFortune();
	}

}

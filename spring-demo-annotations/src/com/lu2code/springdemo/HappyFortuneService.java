package com.lu2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune()
	{
		
		return "HappyFortuneService : Today is your lucky day ";
		
	}

}

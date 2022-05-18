package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpAppHero {
	
	public static void main(String[] args) {
		SpringApplication.run(SpAppHero.class,args);
	}
}

//docker run --name pgtp -e POSTGRES_PASSWORD=tp -e POSTGRES_DB=Card -p 55432:5432 -d postgres
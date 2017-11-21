package com.wisely.ch6_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//定时任务
public class Ch64Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch64Application.class, args);
	}
}

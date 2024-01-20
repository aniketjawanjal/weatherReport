package com.net.weather.report.WeatherReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.net.weather.report.WeatherReport")
public class WeatherReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherReportApplication.class, args);
		System.out.println("Started...");
	}
	
	

}

package com.net.weather.report.WeatherReport.entity;

import org.springframework.stereotype.Component;

@Component
public class sys {
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

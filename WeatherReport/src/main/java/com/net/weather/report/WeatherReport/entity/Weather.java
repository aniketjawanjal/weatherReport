package com.net.weather.report.WeatherReport.entity;

import org.springframework.stereotype.Component;

@Component
public class Weather {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

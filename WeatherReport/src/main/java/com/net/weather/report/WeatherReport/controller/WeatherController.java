package com.net.weather.report.WeatherReport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.net.weather.report.WeatherReport.entity.WeatherData;
import com.net.weather.report.WeatherReport.entity.WeatherEntity;
import com.net.weather.report.WeatherReport.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService service;

	@GetMapping("getweather")
	public String weatherReportDemo() {
		return "Today Weather...";
	}

	@PostMapping("weather")
	public String getWeatherReport(@RequestBody String city) throws JsonMappingException, JsonProcessingException {
		System.out.println("City :: " + city);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(city);

		String specificValue = jsonNode.get("city").asText();

		WeatherData weatherData = service.getWeather(specificValue);
		if (weatherData != null) {
			return String.format("Weather in %s, %s: %s%nTemperature: %.2f°C", weatherData.getName(),
					weatherData.getSys().getCountry(), weatherData.getWeathers()[0].getDescription(),
					weatherData.getMain().getTemp() - 273.15

			);
		} else {
			return "Unable To Fetch Weather Data...";

		}

	}

	@GetMapping("getAllWeatherData")
	public List<WeatherEntity> getAllWeatherData() {
		return service.getAllWeatherData();
	}
	
	@GetMapping("getWeatherById/{id}")
	public String getWeatherInfoUsingID(@PathVariable long id) {
		WeatherEntity usingId = service.getWeatherInfoUsingId(id);
	
		if(usingId !=  null) {
			return String.format("Weather in %s, %s: %s%nTemperature: %.2f°C", 
					usingId.getCityName(),
					usingId.getCountry(),
					usingId.getDescription(),
					usingId.getTemperature() 
					);
		}else {
			return "Weather Data Not Found The Data Base..";
		}
	
	}

}

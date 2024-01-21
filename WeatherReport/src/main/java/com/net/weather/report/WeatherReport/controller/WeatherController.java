package com.net.weather.report.WeatherReport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> getWeatherReport(@RequestBody String city)
			throws JsonMappingException, JsonProcessingException {
		
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(city);

			String specificValue = jsonNode.get("city").asText();

			WeatherData weatherData = service.getWeather(specificValue);
			if (weatherData != null) {
				return new ResponseEntity<String>(String.format("Weather in %s, %s: %s%nTemperature: %.2f°C",
						weatherData.getName(), weatherData.getSys().getCountry(),
						weatherData.getWeathers()[0].getDescription(), weatherData.getMain().getTemp() - 273.15),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("getAllWeatherData")
	public ResponseEntity<List<WeatherEntity>> getAllWeatherData() {
		List<WeatherEntity> weatherData = service.getAllWeatherData();

		if (weatherData != null) {
			return new ResponseEntity<List<WeatherEntity>>(weatherData, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<WeatherEntity>>(weatherData, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("getWeatherById/{id}")
	public ResponseEntity<String> getWeatherInfoUsingID(@PathVariable long id) {

		WeatherEntity usingId = service.getWeatherInfoUsingId(id);

		if (usingId != null) {
			return new ResponseEntity<String>(String.format("Weather in %s, %s: %s%nTemperature: %.2f°C",
					usingId.getCityName(), usingId.getCountry(), usingId.getDescription(), usingId.getTemperature()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Weather Data Not Found The Data Base..", HttpStatus.BAD_REQUEST);
		}

	}

}

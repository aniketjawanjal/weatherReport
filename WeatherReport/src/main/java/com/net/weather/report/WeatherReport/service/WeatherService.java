package com.net.weather.report.WeatherReport.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.net.weather.report.WeatherReport.dao.WeatherDao;
import com.net.weather.report.WeatherReport.entity.WeatherData;
import com.net.weather.report.WeatherReport.entity.WeatherEntity;

@Service
public class WeatherService {

	@Autowired
	private WeatherDao dao;

//	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	ObjectMapper mapper;

	@Autowired
	private WeatherData weatherData;

	@Value("${weather.api.key}")
	private String apiKey;

	@Value("${weather.api.url}")
	private String api_Url;

	public WeatherData getWeather(String city) {

//		String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);

		String endPoint = String.format(api_Url, city, apiKey);
		System.out.println("Endpoints :: " + endPoint);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPoint)).build();
		System.out.println("weather request :: " + request);
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("weather response String :: " + response.body());
			WeatherData weatherData = mapper.readValue(response.body(), WeatherData.class);

			if (weatherData != null) {
				WeatherEntity weatherEntity = weatherData.toEntity();
				dao.saveWeatherData(weatherEntity);
			} else {
				System.out.println("Weather is null..");
			}

			return weatherData;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<WeatherEntity> getAllWeatherData() {
		return dao.getAllWeatherData();
	}

	public WeatherEntity getWeatherInfoUsingId(long id) {
		return dao.getWeatherInfoUsingId(id);
	}
}

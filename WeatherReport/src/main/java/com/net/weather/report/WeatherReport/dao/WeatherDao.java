package com.net.weather.report.WeatherReport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.net.weather.report.WeatherReport.entity.WeatherEntity;
import com.net.weather.report.WeatherReport.exceptionHandler.ResourceNotFoundException;
import com.net.weather.report.WeatherReport.repository.WeatherRepo;

@Repository
public class WeatherDao {
	@Autowired
	private WeatherRepo repo;

	public WeatherEntity saveWeatherData(WeatherEntity weatherEntity) {
		return repo.save(weatherEntity);
	}

	public List<WeatherEntity> getAllWeatherData() {
		return repo.findAll();
	}

	public WeatherEntity getWeatherInfoUsingId(long id) {
		WeatherEntity WeatherEntity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Weather", "ID :", id));
		return WeatherEntity;
	}
}

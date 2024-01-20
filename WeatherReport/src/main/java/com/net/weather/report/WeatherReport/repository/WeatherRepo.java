package com.net.weather.report.WeatherReport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.net.weather.report.WeatherReport.entity.WeatherEntity;

public interface WeatherRepo extends JpaRepository<WeatherEntity, Long> {

}

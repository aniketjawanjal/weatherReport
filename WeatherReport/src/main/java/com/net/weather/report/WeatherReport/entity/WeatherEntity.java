package com.net.weather.report.WeatherReport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cityName;
	private String country;
	private String description;
	private double temperature;

	public WeatherEntity(long id, String cityName, String country, String description, double temperature) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.country = country;
		this.description = description;
		this.temperature = temperature;
	}

	public WeatherEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "WeatherEntity [id=" + id + ", cityName=" + cityName + ", country=" + country + ", description="
				+ description + ", temperature=" + temperature + "]";
	}

}

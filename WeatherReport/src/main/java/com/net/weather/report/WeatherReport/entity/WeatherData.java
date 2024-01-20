package com.net.weather.report.WeatherReport.entity;



import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class WeatherData {

	

	private String name;
	private sys sys;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("weather")
	private Weather[] weather;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public sys getSys() {
		return sys;
	}

	public void setSys(sys sys) {
		this.sys = sys;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Weather[] getWeathers() {
		return weather;
	}

	public void setWeathers(Weather[] weathers) {
		this.weather = weathers;
	}

	public WeatherEntity toEntity() {
		WeatherEntity entity = new WeatherEntity();
		System.out.println(this.weather);
		entity.setCityName(name);
		entity.setCountry(sys.getCountry());
		entity.setDescription(weather[0].getDescription());
		entity.setTemperature(main.getTemp());
		return entity;
	}

}

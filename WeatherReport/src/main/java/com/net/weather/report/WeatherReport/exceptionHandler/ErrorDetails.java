package com.net.weather.report.WeatherReport.exceptionHandler;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timestamp;
	private String name;
	private String path;
	private String errorCode;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime timestamp, String name, String path, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.path = path;
		this.errorCode = errorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", name=" + name + ", path=" + path + ", errorCode=" + errorCode
				+ "]";
	}

}

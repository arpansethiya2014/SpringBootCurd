package com.weather.weather.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "findByCountry", procedureName = "FindByCountry", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "weather_country", type = String.class) }, resultClasses = Weather.class) })
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long weather_id;
	private String city;
	private long timezone;
	private String country;
	private double temp;
	private double temp_min;
	private double temp_max;
	private String main;
	private String max_pressure;
	private String description;

	public Weather() {
	}

	public Weather(long weather_id, String city, long timezone, String country, double temp, double temp_min,
			double temp_max, String main, String max_pressure, String description) {
		super();
		this.weather_id = weather_id;
		this.city = city;
		this.timezone = timezone;
		this.country = country;
		this.temp = temp;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.main = main;
		this.max_pressure = max_pressure;
		this.description = description;
	}

	public long getWeather_id() {
		return weather_id;
	}

	public void setWeather_id(long weather_id) {
		this.weather_id = weather_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getTimezone() {
		return timezone;
	}

	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getMax_pressure() {
		return max_pressure;
	}

	public void setMax_pressure(String max_pressure) {
		this.max_pressure = max_pressure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

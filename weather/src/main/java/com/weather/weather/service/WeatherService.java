package com.weather.weather.service;

import java.util.Optional;
import java.util.*;
import com.weather.weather.entity.Weather;

public interface WeatherService {

	Weather save (Weather weather);
	
	void deleteById(long id);
	
	Optional<Weather> findById(long id);
	
	List<Weather> findAll();
	
	Optional<Weather> findByCity(String city);
}

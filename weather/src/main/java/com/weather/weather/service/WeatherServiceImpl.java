package com.weather.weather.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.weather.entity.Weather;
import com.weather.weather.repo.WeatherRepository;

@Service
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	private WeatherRepository weatherRepo;
	
	@Override
	public Weather save(Weather weather) {
		
		
		return weatherRepo.save(weather);
	}

	@Override
	public void deleteById(long id) {
	   weatherRepo.deleteById(id);	
	}

	@Override
	public Optional<Weather> findById(long id) {
		return weatherRepo.findById(id);
	}

	@Override
	public List<Weather> findAll() {
		return weatherRepo.findAll();
	}

	
	
}

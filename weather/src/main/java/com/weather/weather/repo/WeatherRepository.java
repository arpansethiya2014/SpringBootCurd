package com.weather.weather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.weather.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}

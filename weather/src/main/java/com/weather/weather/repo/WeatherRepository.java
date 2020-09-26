package com.weather.weather.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weather.weather.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

	@Query(value = "SELECT * FROM Weather w WHERE w.city = ?",nativeQuery = true)
	Optional<Weather> findByCity(String city);
	
}

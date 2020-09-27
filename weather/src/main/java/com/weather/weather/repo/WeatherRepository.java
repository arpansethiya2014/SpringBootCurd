package com.weather.weather.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weather.weather.entity.Weather;
import java.util.*;
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

	@Query(value = "SELECT * FROM Weather w WHERE w.city = ?",nativeQuery = true)
	Optional<Weather> findByCity(String city);

	
	@Query(value = "call FindByCountry( ?1 );", nativeQuery = true)
	List<Weather> findByCountryProcedure(@Param("weather_country") String country);
}

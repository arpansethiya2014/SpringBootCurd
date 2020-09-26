package com.weather.weather.controller;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weather.ThirdPartyAPIs.ThirdPartyAPIs;
import com.weather.weather.entity.Weather;
import com.weather.weather.exception.ResourceNotFoundException;
import com.weather.weather.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@PostMapping("/weather")
	public String saveWeather() throws Exception {
		Weather weather = new Weather();
       String response = ThirdPartyAPIs.getData();
		
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(response);
		JSONObject jsonObject = (JSONObject) obj;
		String name = (String) jsonObject.get("name");
		long timezone = (long) jsonObject.get("timezone");
		JSONObject main = (JSONObject) jsonObject.get("main");
		double temp = (double) main.get("temp");
		double temp_min = (double) main.get("temp_min");
		double temp_max = (double) main.get("temp_max");
		JSONObject sys = (JSONObject) jsonObject.get("sys");
		String country = (String) sys.get("country");
		
		weather.setCity(name);
		weather.setTimezone(timezone);
		weather.setTemp(temp);
		weather.setTemp_max(temp_max);
		weather.setTemp_min(temp_min);
		weather.setCountry(country);
		weather.setMain(main.toString());
		
		weatherService.save(weather);
		return "Save";
	}
	
	@DeleteMapping("/weather/{id}")
	public String deleteById(@PathVariable("id") long id) {
		return weatherService.findById(id).map(p -> {
			weatherService.deleteById(id);
            return "Weather deleted";
        }).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
	}
	
	@GetMapping("/weather")
	public List<Weather> findAll(){
		return weatherService.findAll();
	}
	
	@GetMapping("/weather/{id}")
	public Weather findById(@PathVariable("id") long id) {
		return weatherService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id " + id + " not found"));
	}
}

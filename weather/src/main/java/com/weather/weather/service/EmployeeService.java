package com.weather.weather.service;

import java.util.Optional;
import java.util.*;
import com.weather.weather.entity.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	
	void deleteById(long id);
	
	Optional<Employee> searchById(long id);
	
	List<Employee> findAll();
	
	List<Employee> findByMobile(String mobile);
	
}

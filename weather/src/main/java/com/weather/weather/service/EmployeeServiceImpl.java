package com.weather.weather.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.weather.entity.Employee;
import com.weather.weather.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo; 
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteById(long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Optional<Employee> searchById(long id) {
		return employeeRepo.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public List<Employee> findByMobile(String mobile) {
		return employeeRepo.findByMobile(mobile);
	}

	
	
}

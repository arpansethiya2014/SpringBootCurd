package com.weather.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weather.entity.Employee;
import com.weather.weather.service.EmployeeService;
import java.util.*;
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public String Save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "Save";
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		return employeeService.searchById(id).orElseThrow(()-> new RuntimeException("Id " + id + " not found"));
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteById(@PathVariable("id") long id) {
		return employeeService.searchById(id).map(p -> {
			employeeService.deleteById(id);
			return "Employee deleted";
		}).orElseThrow(() -> new RuntimeException("Id : " + id + "Not Found"));
	}
	
	@PutMapping("/employee/{id}")
	public String updateById(@PathVariable("id") long id , @RequestBody Employee employee) {
		return employeeService.searchById(id).map(p -> {
			p.setName(employee.getName());
			p.setMobile(employee.getMobile());
			p.setEmail(employee.getEmail());
			p.setAddress(employee.getAddress());
			employeeService.save(p);
			return "Employee Update";
		}).orElseThrow(() -> new RuntimeException("Id : " + id + "Not Found"));
	}
	
	@PatchMapping("/employee/{id}")
	public String updateByIdMobile(@PathVariable("id") long id , @RequestBody Employee employee) {
		return employeeService.searchById(id).map(p -> {
			p.setMobile(employee.getMobile());
			employeeService.save(p);
			return "Employee Mobile Number Update";
		}).orElseThrow(() -> new RuntimeException("Id : " + id + "Not Found"));
	}
	
	@GetMapping("/employeeMobile/{mobile}")
	List<Employee> findByMobile(@PathVariable("mobile") String mobile){
		return employeeService.findByMobile(mobile);
	}
}

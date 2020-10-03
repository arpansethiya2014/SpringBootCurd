package com.weather.weather.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weather.weather.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	@Query(value = "Select * from Employee e where e.mobile=?",  nativeQuery = true)
	List<Employee> findByMobile(String mobile);
	
}

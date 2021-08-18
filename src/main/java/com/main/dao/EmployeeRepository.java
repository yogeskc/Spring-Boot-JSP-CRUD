package com.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
	
	
	
	
	
}

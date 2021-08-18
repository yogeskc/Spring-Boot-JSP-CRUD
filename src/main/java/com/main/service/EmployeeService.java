package com.main.service;

import java.util.List;

import com.main.dto.EmployeeDTO;

public interface EmployeeService {	
	
	List<EmployeeDTO> FetchAllEmployees();

	void saveEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO fetchEmployee(int employeeId);

	void deleteEmp(int employeeId);
	
}

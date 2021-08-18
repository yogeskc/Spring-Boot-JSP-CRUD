package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.EmployeeRepository;
import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository ;

	
	
	
	public List<EmployeeDTO> FetchAllEmployees(){
		
		List<EmployeeEntity> entityList=employeeRepository.findAll();
		List<EmployeeDTO> dtoList=new ArrayList<>();//blank list
		for(  EmployeeEntity entity: entityList){
			
			EmployeeDTO dto=new EmployeeDTO();//blank object
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
			
		}
		
			return dtoList;
	}
	

	@Override
	public EmployeeDTO fetchEmployee(int employeeId) {
		EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).get();
		EmployeeDTO employeeDTO =new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, employeeDTO);	
		return employeeDTO;
	}
	

	
	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		employeeRepository.save(employeeEntity);
	}


	@Override
	public void deleteEmp(int employeeId) {
		// TODO Auto-generated method stub
		 employeeRepository.deleteById(employeeId);
	}

	

	
	

}

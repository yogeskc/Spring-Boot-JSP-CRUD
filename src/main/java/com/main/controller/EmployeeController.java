package com.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.main.dto.EmployeeDTO;
import com.main.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired
	//EmpoloyeeDaoImpl empoloyeeDaoImpl ;
	EmployeeService  employeeService;
	
	
@GetMapping("showEmployees")
	
	String showAll(Model model){	
		
	   List<EmployeeDTO>   employeeDTOlist=employeeService.FetchAllEmployees();	   	  
	   model.addAttribute( "employeeDTOlist"  ,employeeDTOlist);
	   return "showAllEmp";//showAllEmp.jsp
	}

@PostMapping("updateEmployee")	
String updateEmp(@ModelAttribute EmployeeDTO  employeeDTO){	
	employeeService.saveEmployee(employeeDTO);
	return "redirect:showEmployees";
}

@GetMapping("deleteEmployee")
String deleteEmp(@RequestParam int employeeId){
	employeeService.deleteEmp(employeeId);
	return "redirect:showEmployees";
	
}


@GetMapping("showEditEmployee")
String showEditPage(@RequestParam int employeeId , Model model){
	EmployeeDTO employeeDTO=employeeService.fetchEmployee(employeeId);
	model.addAttribute("employeeDTO", employeeDTO);
	
	return "edit";
	
}

@GetMapping("register")	
	String registerEmp() {
	
		return "employeeRegistration"; 
}

@PostMapping("register")	
String registerEmp(@ModelAttribute  EmployeeDTO employeeDTO){	
	employeeService.saveEmployee(employeeDTO);
	return "employeeRegistration";
}

@GetMapping("login")	
String loginEmp() {

	return "login"; 
}
	

}	



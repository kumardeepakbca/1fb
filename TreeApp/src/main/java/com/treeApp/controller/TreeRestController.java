package com.treeApp.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.treeApp.dto.EmployeeDTO;

@RestController
public class TreeRestController {

	
	/*@RequestMapping(value = "/addEmployee" , method = RequestMethod.POST, consumes = "application/json")
	public void addEmployee(@RequestBody EmployeeDTO employee){
		
		
		//treeAppService.addEmployee(employee);
		
		
		System.out.println(" the front data is " + employee.getName() + " " + employee.getDesignation() + " " + employee.getManagerName() + " " + employee.getSalary());
		
	}*/
}

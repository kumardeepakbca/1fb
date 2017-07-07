package com.treeApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.treeApp.dto.EmployeeDTO;
import com.treeApp.dto.ResultDTO;
import com.treeApp.dto.TreeDTO;
import com.treeApp.service.TreeAppService;

@Controller
public class TreeAppController {

	@Autowired
	private TreeAppService treeAppService;
	
	@RequestMapping(value= "/")
	public String landingPage(){
		//String s = "Main";
		
		
		return "Main";
	}
	
	@RequestMapping(value = "/addEmployee" , method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResultDTO addEmployee(@RequestBody EmployeeDTO employee){
		
		
		System.out.println(" the front data is " + employee.getName() + " " + employee.getDesignation() + " " + employee.getManagerName() + " " + employee.getSalary());
		treeAppService.addEmployee(employee);
		ResultDTO r1 = new ResultDTO();
		r1.setResult("SUCCESS");
		return r1;
	
	}
	
	@RequestMapping(value = "/managerlist" , method = RequestMethod.GET, consumes = "application/json")
	@ResponseBody
	public List<TreeDTO> getListOfManager(){
		List<TreeDTO> mgrList = new ArrayList<TreeDTO>();
		mgrList = treeAppService.listOfManager();
		
		
		return mgrList;
	}
	
	@RequestMapping(value = "/emDetails" , method = RequestMethod.GET)
	@ResponseBody
	public EmployeeDTO getEmployeeDetails(@RequestParam String id){
		EmployeeDTO emp = new EmployeeDTO();
		emp = treeAppService.getEmpDetails(id);
		return emp;
	}
	
}

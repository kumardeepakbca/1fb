package com.treeApp.service;

import java.util.List;

import com.treeApp.dto.EmployeeDTO;
import com.treeApp.dto.TreeDTO;

public interface TreeAppService {

	public void addEmployee(EmployeeDTO emp);
	
	public List<TreeDTO> listOfManager();

	public EmployeeDTO getEmpDetails(String id);
	
}

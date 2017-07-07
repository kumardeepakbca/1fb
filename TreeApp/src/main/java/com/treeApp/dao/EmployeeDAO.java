package com.treeApp.dao;

import java.util.List;

import com.treeApp.Model.Employee;

public interface EmployeeDAO {

	public void addEmp(Employee emp);
	
	public List<String> getManagers();
	
	public List<Employee> getEmpForMgr(String managerName);

	public List<Employee> getEmployeeDetails(int parseInt);
	
}

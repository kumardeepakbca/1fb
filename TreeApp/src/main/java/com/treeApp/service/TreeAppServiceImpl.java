package com.treeApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.treeApp.Model.Employee;
import com.treeApp.dao.EmployeeDAO;
import com.treeApp.dto.EmployeeDTO;
import com.treeApp.dto.ManagerDTO;
import com.treeApp.dto.TreeDTO;


@Service
@Transactional
public class TreeAppServiceImpl implements TreeAppService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void addEmployee(EmployeeDTO emp) {
	
		Employee empModel = new Employee();
		
		empModel.setName(emp.getName());
		empModel.setDesignation(emp.getDesignation());
		empModel.setSalary(emp.getSalary());
		empModel.setManagername(emp.getManagerName());
		
		employeeDAO.addEmp(empModel);
	}

	public List<TreeDTO> listOfManager() {
		List<String> mg = new ArrayList<String>();
		List<TreeDTO> mgrTree = new ArrayList<TreeDTO>();
		//List<TreeDTO> childs = new ArrayList<TreeDTO>();
		mg = employeeDAO.getManagers();
		
		if((mg.size() > 0) && (mg != null) ){
			
			Iterator<String> itr = mg.listIterator();
			
			while(itr.hasNext()){
				String managerName = (String)itr.next();
				List<Employee> empList = employeeDAO.getEmpForMgr(managerName);
				ManagerDTO t = new ManagerDTO();
				t.setId(managerName);
				//t.setParent("#");
				t.setText(managerName);
				if((empList.size() > 0) && (empList != null) ){
					t.setChildren(createChildJSON(empList));
				}else{
					System.out.println("Employee List is Empty for ::" + managerName);
				}
				mgrTree.add(t);
			}
		}else{
			System.out.println("The list from db is empty");
		}
		
		
		return mgrTree;
	}

	private List<TreeDTO> createChildJSON(List<Employee> empList) {
        List<TreeDTO> child = new ArrayList<TreeDTO>();
		Iterator<Employee> itr = empList.listIterator();
		while(itr.hasNext()){
			Employee emp = (Employee)itr.next();
			TreeDTO t1 = new TreeDTO();
			t1.setId(Integer.toString(emp.getId()));
			t1.setText(emp.getName());
			//t1.setParent(emp.getManagername());
			
			child.add(t1);
		}
		return child;
	}

	public EmployeeDTO getEmpDetails(String id) {
        EmployeeDTO emp =  new EmployeeDTO();
        List<Employee> l1 = employeeDAO.getEmployeeDetails(Integer.parseInt(id));
        if((l1.size() > 0) && (l1 != null)){
        	Iterator<Employee> itr = l1.listIterator();
        	while(itr.hasNext()){
        		Employee emp1 = (Employee)itr.next();
        		emp.setId(emp1.getId());
        		emp.setName(emp1.getName());
        		emp.setDesignation(emp1.getDesignation());
        		emp.setSalary(emp1.getSalary());
        		emp.setManagerName(emp1.getManagername());
        	}
        }
		
		return emp;
	}

}

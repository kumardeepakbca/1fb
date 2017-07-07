package com.treeApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.treeApp.Model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void addEmp(Employee emp) {

		Session session = sessionFactory.openSession();
		session.save(emp);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getManagers() {
      List<String> mgrs = new ArrayList<String>();
      Session session = sessionFactory.openSession();
      Query q = session.createQuery("Select distinct managername from Employee");
      mgrs = q.list();
		
		return mgrs;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmpForMgr(String managerName) {

		List<Employee> emps = new ArrayList<Employee>();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee where managername = :mgrName").setParameter("mgrName", managerName);
		emps = q.list();
		
		return emps;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeDetails(int parseInt) {
		List<Employee> emp = new ArrayList<Employee>();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee where id = :empId").setParameter("empId", parseInt);
		emp = q.list();
		return emp;
	}

}

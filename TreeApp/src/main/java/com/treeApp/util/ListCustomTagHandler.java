package com.treeApp.util;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.treeApp.dto.EmployeeDTO;

public class ListCustomTagHandler extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	List<EmployeeDTO> list;


	public void setlist(List<EmployeeDTO> employeeList) {
		this.list = employeeList;
	}
	
	public int doStartTag() throws JspException {
		
		JspWriter out=pageContext.getOut();  
	    try{  
	        //out.print(number*number*number);
	    	
	    	StringBuilder sb =  new StringBuilder();
	    	sb.append("<table style=\"width:100%\"><tr><th>ID</th><th>Name</th><th>Designation</th><th>Manager Name</th><th>Salary</th></tr>");
	    	if((list.size() > 0) && (list != null)){
	    			
	    		Iterator<EmployeeDTO> itr = list.listIterator();
	    		while(itr.hasNext()){
	    			EmployeeDTO e1 = (EmployeeDTO)itr.next();
	    			String s = "<tr><td>" + e1.getId() + "</td>"
	    						  + "<td>" + e1.getName()  + "</td>" 
	    						   + "<td>" + e1.getDesignation()  + "</td>" 
	    						    + "<td>" + e1.getManagerName()  + "</td>" 
	    						    + "<td>" + e1.getSalary() + "</td></tr>";
	    		sb.append(s);
	    		}
	    		
	    		String s1 = "</table>";
	    		sb.append(s1);
	    		out.println(sb.toString());
	    		
	    		
	    		
	    	}else{
	    		out.print("The List is empty or null");
	    	}
	    	
	    	
	    }catch(Exception e){e.printStackTrace();}  
		return SKIP_BODY;
	}
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
function registerAjax(){
	 var dataMap = {};
	var name = $("#name").val();
	var designation = $("#designation").val();
	var salary = $("#salary").val();
    var managerName = $("#managerName option:selected").val();
    
    alert("Hi jquery is set up " + name +"  " + designation + " " + salary + " " + managerName);
    dataMap["name"] = name;
    dataMap["designation"] = designation;
    dataMap["salary"] = salary;
    dataMap["managerName"] = managerName;
   // var dataMap1 = {"name" : "nameq", "salary" : "qsalary" , "designation" : "qdesignation" , "managerName" : "qmanagerName" };
   $("#name").val("");
       	 $("#managerName").val("");
       	 $("#salary").val("");
       	 $("#designation").val("");
    $.ajax({
        url : 'addEmployee',
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        type: "POST",
        dataType: "json",
        data: JSON.stringify(dataMap),
        success : function() {
           alert(" Record Added Succesfully");
        	
        }
    });
}


</script>
</head>
<body>
 <div align="center">
        <form:form action="register" method="post">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Employee Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" id="name"  /></td>
                </tr>
                <tr>
                    <td>Manager Name:</td>
                    <td><select id="managerName">
 						  <option value="volvo">Volvo</option>
						  <option value="saab">Saab</option>
 						  <option value="mercedes">Mercedes</option>
						  <option value="audi">Audi</option>
						</select>
					</td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><input type="text" id="salary" /></td>
                </tr>
                <tr>
                    <td>Designation:</td>
                    <td><input type="text" id="designation" /></td>
                </tr>
               
                <tr>
                    <td colspan="2" align="center"><input type="button" value="Register" onClick="registerAjax()"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
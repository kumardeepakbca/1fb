<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/js/jstree/dist/themes/default/style.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script src="resources/js/jstree/dist/jstree.min.js"></script>
 <script type="text/javascript">
$(function() {
	 $.ajax({
	        url : 'managerlist',
	        headers: { 
	            'Accept': 'application/json',
	            'Content-Type': 'application/json' 
	        },
	        success : function(data) {
	            //$('#result').html();
	            $('#jstree_demo_div').jstree({ 'core' : {
	                'data' : data,
	                "check_callback" : true
	            } ,
	            "plugins" : ["contextmenu"],
	            "contextmenu": {
	                "items": function ($node) {
	                    return {
	                        "Details": {
	                            "label": "Show Details of employee",
	                            "action": function (obj) {
	                                //this.create(obj);
	                                
	                               // alert("Hi I will so details" + $($node).attr('id'));
	                                $.ajax({
	                        	        url : 'emDetails?id=' + $($node).attr('id'),
	                        	        headers: { 
	                        	            'Accept': 'application/json',
	                        	            'Content-Type': 'application/json' 
	                        	        },
	                        	        success : function(data) {
	                        	        	// alert("Hi I will so details" + JSON.stringify(data));
	                        	        	 $("#name1").val(data.name);
	                        	        	 $("#managername").val(data.managerName);
	                        	        	 $("#salary1").val(data.salary);
	                        	        	 $("#designation1").val(data.designation);
	                        	        }
	                        	        });
	                            }
	                        },
	                    };
	                }
	            }
	        });
	    }
	
	 }) 
})

</script>
</head>
<body>
<h3> tree list will come here</h3>
<div id="main" style="display: -webkit-inline-box;">
 <div id="jstree_demo_div" style="width: 626px;"></div>
  <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Employee Details</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" id="name1"  /></td>
                </tr>
                <tr>
                    <td>Manager Name:</td>
                    <td><input type="text" id="managername"  />
					</td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><input type="text" id="salary1" /></td>
                </tr>
                <tr>
                    <td>Designation:</td>
                    <td><input type="text" id="designation1" /></td>
                </tr>
               
                
            </table>
 </div>
</body>
</html>
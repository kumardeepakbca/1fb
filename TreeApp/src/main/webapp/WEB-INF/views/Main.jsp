<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Tree Application</title>
<style>
body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}

/* Style the close button */
.topright {
    float: right;
    cursor: pointer;
    font-size: 20px;
}

.topright:hover {color: red;}
</style>
<link rel="stylesheet" href="resources/js/jstree/dist/themes/default/style.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script src="resources/js/jstree/dist/jstree.min.js"></script>
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
        success : function(data) {
           alert(" Record Added Succesfully");
        	
        }
    });
}


</script>
</head>
<body>

<center>Employee Tree Application</center>

<p>Click on the x button in the top right corner to close the current tab:</p>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Register</button>
  <button class="tablinks" onclick="openCity(event, 'Paris')">List</button>
<!--   <button class="tablinks" onclick="openCity(event, 'Tokyo')">Tokyo</button> -->
</div>

<div id="London" class="tabcontent">
  <span onclick="this.parentElement.style.display='none'" class="topright">x</span>
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
</div>

<div id="Paris" class="tabcontent">
  <span onclick="this.parentElement.style.display='none'" class="topright">x</span>
  <div id="main" style="display: -webkit-inline-box;">
 <div id="jstree_demo_div" style="width: 626px;"></div>
  <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Employee Details</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><label id="name1"></label>
                </tr>
                <tr>
                    <td>Manager Name:</td>
                    <td><label id="managername"></label>
					</td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><label id="salary1"></label>
                </tr>
                <tr>
                    <td>Designation:</td>
                    <td><label id="designation1"></label>
                </tr>
               
                
            </table>
 </div>
</div>

<!-- <div id="Tokyo" class="tabcontent">
  <span onclick="this.parentElement.style.display='none'" class="topright">x</span>
  <h3>Tokyo</h3>
  <p>Tokyo is the capital of Japan.</p>
</div> -->

<script>
function openCity(evt, cityName) {
	
	if(cityName == "Paris"){
		
		
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
		                        	        	 $("#name1").html(data.name);
		                        	        	 $("#managername").html(data.managerName);
		                        	        	 $("#salary1").html(data.salary);
		                        	        	 $("#designation1").html(data.designation);
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
	}
	
	
	
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>



</body>
</html>
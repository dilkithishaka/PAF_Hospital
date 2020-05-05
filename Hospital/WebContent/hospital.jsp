<%@page import="com.HospitalService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Management</title>
<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/hospital.js"></script>
<link href="Views/css/bootstrap.min.css" rel="stylesheet">
<link href="Views/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container"> 
 
  <div class="row">    
  <div class="col-8">
<h1>Hospital Management</h1>
			
	<form id="formHospital" name="formHospital" method="post" action="hospital.jsp">  
	Hospital Name:  <input id="hospitalName" name="hospitalName" type="text"        
		class="form-control form-control-sm">  
	<br> 
	City:  <input id="city" name="city" type="text"        
		class="form-control form-control-sm">  
	<br> 
	Address:  <input id="address" name="address" type="text"        
		class="form-control form-control-sm"> 
	<br> 
	Email:  <input id="email" name="email" type="text"       
		class="form-control form-control-sm">  
	<br>  
	Contact Number:  <input id="contactNumber" name="contactNumber" type="text"       
		class="form-control form-control-sm">  
	<br>
	
	<input id="btnSave" name="btnSave" type="button" value="Save"      
		class="btn btn-primary"> 
    <input type="hidden" id="hidHospitalIDSave" name="hidHospitalIDSave" value=""> 
	</form> 
	
	<div id="alertSuccess" class="alert alert-success"></div>
	
	<div id="alertError" class="alert alert-danger"></div> 
	<br>	
	<div id="hospitlDetailGrid">
					<%
						HospitalService hospitalService = new HospitalService();
						out.print(hospitalService.viewHospitals());
					%>
				</div>

	</div>
	</div>
	</div>

</body>
</html>
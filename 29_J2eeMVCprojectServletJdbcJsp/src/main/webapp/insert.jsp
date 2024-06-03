<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Insert Student details here</h1>
<form action="insertstudent" method="post">
<input type = "text" name = "sname" placeholder = "enter student name"/>
<br>
<input type = "text" name = "course" placeholder = "enter course name"/>
<br>
<label for="rdGender">Gender:</label>
	<input type ="radio" class="rdGender" name="rdGender" value="Male"/><span>Male</span>
	<input type ="radio" class="rdGender" name="rdGender" value="Female"/><span>Female</span>
	<br/>
	
	<label for="tbEmail">Email:</label> 
	     <input type="text" id="tbEmail" name="tbEmail"  placeholder = "enter email"/>
	<br/>
	
	<label for="chkqual">Subject:</label>
	     <input type ="checkbox" class="chkqual" name="chkqual" value="MCA"/><span>MCA</span>
	     <input type ="checkbox" class="chkqual" name="chkqual" value="M-Tech"/><span>M-Tech</span>
	     <input type ="checkbox" class="chkqual" name="chkqual" value="B-Tech"/><span>B-Tech</span>
	<br/>
	

<input type = "submit" value= "insert student data into database"/>



</form>
</body>
</html>
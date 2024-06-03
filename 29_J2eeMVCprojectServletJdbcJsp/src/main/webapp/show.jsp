<%@page import="com.techpalle.model.Student"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Details :</h1>
<%
// Reading ArrayList data coming from servlet

ArrayList<Student> al =(ArrayList<Student>)request.getAttribute("students");
// getAttribute() will give you object type, but we have to convert to "ArrayListofStudent" object type so we use (ArrayList<Student>)
%>
<table border = "2">
<%
for(Student s1: al)
{
%>
<tr bgcolor = "yellow">
<td><%=s1.getSno() %></td>
<td><%=s1.getSname() %></td>
<td><%=s1.getCourse() %></td>
<td><%=s1.getGender() %></td>
<td><%=s1.getEmail() %></td>
<td><%=s1.getQual() %></td>
</tr>

<%
}
%>
</table>

</body>
</html>
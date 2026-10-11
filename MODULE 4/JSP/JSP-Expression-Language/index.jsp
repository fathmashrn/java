<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.Student" %>

<%
    Student s = new Student();

    s.setName("Sherin");
    s.setCourse("Computer Science");
    s.setMarks(90);

    request.setAttribute("student", s);
%>

<html>
<head>
    <title>JSP Expression Language</title>
</head>
<body>

<h2>JSP Expression Language Example</h2>

<h3>Accessing JavaBean Properties</h3>

<p>Name: ${student.name}</p>
<p>Course: ${student.course}</p>
<p>Marks: ${student.marks}</p>

<h3>Accessing Request Parameters</h3>

<form action="index.jsp" method="get">
    Enter your name:
    <input type="text" name="username">
    <input type="submit" value="Submit">
</form>

<p>Entered Name: ${param.username}</p>

</body>
</html>

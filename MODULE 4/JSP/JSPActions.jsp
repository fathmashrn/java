<html>
<body>
    <h2>JSP Actions</h2>

    <jsp:useBean id="student"
                 class="java.util.Date"
                 scope="page" />

    <p>Current Date and Time:</p>

    <jsp:getProperty name="student"
                     property="time" />
</body>
</html>

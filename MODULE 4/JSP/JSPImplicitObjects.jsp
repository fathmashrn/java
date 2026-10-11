<html>
<body>
    <h2>JSP Implicit Objects</h2>

    <p>Request Method: <%= request.getMethod() %></p>

    <p>Server Name: <%= request.getServerName() %></p>

    <p>Session ID: <%= session.getId() %></p>

    <p>Application Name:
        <%= application.getServletContextName() %>
    </p>

    <p>Response Content Type:
        <%= response.getContentType() %>
    </p>
</body>
</html>

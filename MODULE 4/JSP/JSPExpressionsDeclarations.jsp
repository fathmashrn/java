<html>
<body>
    <h2>JSP Expressions and Declarations</h2>

    <%!
        int square(int n) {
            return n * n;
        }
    %>

    <p>Number: 5</p>

    <p>Square of 5: <%= square(5) %></p>

    <p>Current Year:
        <%= java.time.Year.now().getValue() %>
    </p>
</body>
</html>

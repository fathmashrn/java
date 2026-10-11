<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>JSTL Example</title>
</head>
<body>

<h2>Standard Tag Library (JSTL)</h2>

<c:set var="marks" value="85"/>

<h3>1. Conditional Statement</h3>

<c:if test="${marks >= 40}">
    <p>Result: Pass</p>
</c:if>

<h3>2. Choose Statement</h3>

<c:choose>
    <c:when test="${marks >= 90}">
        <p>Grade: A+</p>
    </c:when>

    <c:when test="${marks >= 80}">
        <p>Grade: A</p>
    </c:when>

    <c:otherwise>
        <p>Grade: B</p>
    </c:otherwise>
</c:choose>

<h3>3. Iteration using forEach</h3>

<c:forEach var="i" begin="1" end="5">
    <p>Number: ${i}</p>
</c:forEach>

<h3>4. Formatting</h3>

<fmt:formatNumber value="${marks}" type="number"
                  maxFractionDigits="2"/>

</body>
</html>

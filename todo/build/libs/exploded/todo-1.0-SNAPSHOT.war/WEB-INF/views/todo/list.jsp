<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Todo List</title>
</head>
<body>

<table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td>tno</td>
        <td>title</td>
        <td>dueDate</td>
        <td>finished</td>
        <td>writer</td>
    <tr>
        <c:forEach items="${dtolist}" var="dto">
    <tr>
        <td>${dto.tno}</td>
        <td>${dto.title}</td>
        <td>${dto.dueDate}</td>
        <td>${dto.finished}</td>
        <td>${dto.writer}</td>
    <tr>
        </c:forEach>
</table>
 <!--
<c:forEach var="list" items="${dtolist}">
    ${list}<br>
</c:forEach>
!-->
</body>
</html>


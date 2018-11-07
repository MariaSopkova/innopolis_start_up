<%--
  Created by IntelliJ IDEA.
  User: m.biryukov
  Date: 24.10.2018
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<table>
    <TR>
        <TD>${user.id}</TD>
        <TD>${user.name}</TD>
        <TD>${user.family_name}</TD>
        <TD>${user.age}</TD>
        <TD>${user.role}</TD>
        <TD>${user.language}</TD>
        <TD>${user.city}</TD>
        <TD>${user.pet_id}</TD>
    </TR>
</table>
</body>
</html>

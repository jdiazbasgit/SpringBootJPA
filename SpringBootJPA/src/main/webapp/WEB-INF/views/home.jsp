<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ESTAMOS EN HOME</h1>

<sec:authorize access='hasRole("ROLE_USER")'>
<h1>soy el user</h1>

</sec:authorize>


<sec:authorize access='hasRole("ROLE_ADMIN")'>
<h1>soy el admin</h1>
</sec:authorize>

<a href="/logout">DESCONECTAR</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% String servletPath = request.getRequestURI(); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스트 코드</title>
</head>
<body>

<form:form action="/springView/jsp/article/${article.id}" commandName="article" method="delete">
	<input type="submit" value="삭제">
</form:form>

<form:form action="/springView/jsp/article/${article.id}" commandName="article" method="put">
	<input type="submit" value="수정">
</form:form>

<form:form action="/springView/jsp/article" commandName="article" method="post">
	<input type="submit" value="생성">
</form:form>


</body>
</html>
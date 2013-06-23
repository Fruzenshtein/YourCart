<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
<title><spring:message code="page.title.login" /></title>
</head>
<body>
<div id="container">
<div id="header">
	<%@include file="../header.jsp" %>
</div>
<div id="menu">
	<%@include file="../menu.jsp" %>
</div>
<div id="content">
<h2><spring:message code="page.title.login" /></h2>

<p>


<c:if test="${error == true}">
	<span class="error">Не верное имя пользователя или пароль</span>
</c:if>

</p>

<form method="post" action="<c:url value='j_spring_security_check'/>" >
<table>
<tbody>
<tr>
<td>Email:</td>
<td><input type="text" name="j_username" id="j_username"size="30" maxlength="40"  /></td>
</tr>
<tr>
<td>Пароль:</td>
<td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
</tr>
<tr>
<td>Запомнить пароль?</td>
<td><input type="checkbox" id="remember" name="_spring_security_remember_me" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Войти" /></td>
</tr>
</tbody>
</table>
</form>	

</div>
<div id="footer">
	<%@include file="../footer.jsp" %>
</div>
</div>

</body>
</html>
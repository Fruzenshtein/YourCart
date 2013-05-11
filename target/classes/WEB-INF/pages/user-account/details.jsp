<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../resources/css/main.css" rel="stylesheet" type="text/css" />
<title><spring:message code="page.title.details" /></title>
</head>
<body>
<div id="container">
	<div id="header">
		<%@include file="../header.jsp"%>
	</div>
	<div id="menu">
		<%@include file="../menu.jsp"%>
	</div>
	<div id="content">
		<h2>
			<spring:message code="page.title.details" />
		</h2>
		<p>Здесь можно изменить свою личную информацию.</p>

		<form:form method="POST" commandName="userDetails"
			action="${pageContext.request.contextPath}/user/details.html">
			<table>
				<tbody>
					<tr>
						<td>Имя:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Фамилия:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Пол:</td>
						<td>
							М <form:radiobutton path="sex" value="m" />
							Ж <form:radiobutton path="sex" value="f" />
						</td>
					</tr>
					<tr>
						<td>День рождения:</td>
						<td><form:input path="birthday" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Обновить" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form:form>

	</div>
	<div id="footer">
		<%@include file="../footer.jsp"%>
	</div>
</div>
</body>
</html>
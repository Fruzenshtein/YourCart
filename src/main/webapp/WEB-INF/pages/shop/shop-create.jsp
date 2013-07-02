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
<title><spring:message code="page.title.shop.new" /></title>
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
			<spring:message code="page.title.shop.new" />
		</h2>
		<p>Здесь можно зарегистрировать Ваш магазин.</p>
		<p><span class="success">${success_msg}</span></p>
		<form:form method="POST" commandName="shopDTO"
			action="${pageContext.request.contextPath}/shop/add.html">
			<table>
				<tbody>
					<tr>
						<td>Имя:</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Категория:</td>
						<td>
						<form:select path="category">
							<form:option value="cloth">Одежда</form:option>
							<form:option value="cosmetics">Косметика</form:option>
							<form:option value="food">Еда</form:option>
							<form:option value="chemistry">Бытовая Химия</form:option>
						</form:select>					
						</td>
					</tr>
					<tr>
						<td>Тип:</td>
						<td>
							Интернет <form:radiobutton path="type" value="internet" />
							Реальный <form:radiobutton path="type" value="real" />
							Комбо <form:radiobutton path="type" value="real_internet" />
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="Создать" /></td>
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
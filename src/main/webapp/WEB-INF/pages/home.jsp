<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
<title><spring:message code="page.title.home" /></title>
</head>
<body>
<div id="container">
<div id="header">
	<%@include file="header.jsp" %>
</div>
<div id="menu">
	<%@include file="menu.jsp" %>
</div>
<div id="content">
<p>Добро пожаловать на домашнюю страницу проекта Your Cart. С помощью нашего сервиса Вам удастся с легкостью отслеживать интересные товары и услуги.</p>
</div>
<div id="footer">
	<%@include file="footer.jsp" %>
</div>
</div>

</body>
</html>
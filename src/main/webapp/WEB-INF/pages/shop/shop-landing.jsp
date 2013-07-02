<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
<title><spring:message code="page.title.shop.landing" /></title>
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
<h2><spring:message code="page.title.shop.landing" /></h2>
<p>
Страница для владельцев и модераторов магазинов.
Здесь Вы можете оставить заявку на регистрацию Вашего магазина.
Если Вы являетесь модератором магазина, то также можете перейти в меню управления акциями.
</p>
<div class="shops">
	<ul>
		<li><a href="${pageContext.request.contextPath}/shop/add.html">Новый магазин</a></li>
		<li><a href="${pageContext.request.contextPath}/shop/list/owner.html">Список магазинов</a></li>
	</ul>
</div>
</div>
<div id="footer">
	<%@include file="../footer.jsp" %>
</div>
</div>

</body>
</html>
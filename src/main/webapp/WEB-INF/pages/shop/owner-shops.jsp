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
<link href="../../resources/css/main.css" rel="stylesheet" type="text/css"/>
<title><spring:message code="page.title.owner.shops" /></title>
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
<h2><spring:message code="page.title.owner.shops" /></h2>
<p>
<span class="success">${success_msg}</span><br/>
Список магазинов, которые принадлежат вам:
</p>
<div class="shops">
	<table class="list">
	<thead>
	<tr>
	<th>№</th><th>Название</th><th>Статус</th><th>Действия</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach begin="0" varStatus="loop" var="shop" items="${ownerShops}">
	<tr>
	<td>${loop.index + 1}</td>
	<td>${shop.name}</td>
	<td><spring:message code="shop.is.activated.${shop.shopDetails.activatedStatus}" /></td>
	<td>
	<a href="${pageContext.request.contextPath}/shop/edit/${shop.id}.html">Редактировать</a><br/>
	<a href="${pageContext.request.contextPath}/shop/delete/${shop.id}.html">Удалить</a><br/>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
<div id="footer">
	<%@include file="../footer.jsp" %>
</div>
</div>

</body>
</html>
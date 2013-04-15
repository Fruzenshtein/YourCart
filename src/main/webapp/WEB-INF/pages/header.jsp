<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1><spring:message code="page.title.home" /></h1>
<div id="auth">
<ul>
<li><a href="#">Вход в систему</a></li>
<li><a href="${pageContext.request.contextPath}/user/registration.html">Регистрация</a></li>
</ul>
</div>
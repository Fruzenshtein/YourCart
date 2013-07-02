<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1><spring:message code="page.title.home" /></h1>
<div id="auth">

<sec:authorize access="authenticated" var="authenticated" />
<c:choose>
<c:when test="${authenticated}">
	<ul>
	<li><a href="${pageContext.request.contextPath}/user/account.html"><spring:message code="header.account" /></a></li>
	<li><a href="${pageContext.request.contextPath}/shop/landing.html"><spring:message code="header.shops" /></a></li>
	<li><a href="<c:url value="/j_spring_security_logout" />" ><spring:message code="header.logout" /></a> </li>
	</ul>
</c:when>
<c:otherwise>
	<ul>
	<li><a href="${pageContext.request.contextPath}/user-login.html"><spring:message code="header.login" /></a></li>
	<li><a href="${pageContext.request.contextPath}/registration.html"><spring:message code="header.registration" /></a></li>
	</ul>
</c:otherwise>
</c:choose>


</div>
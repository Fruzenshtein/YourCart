<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
<title><spring:message code="page.title.about.us" /></title>
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
<p>Your Cart поможет Вам не отрываясь от ваших дел, находить необходимые Вам товары и услуги.
Это возможно благодаря:
<ul>
<li>Доступности Your Cart на всех популярных устройствах</li>
<li>Интеллектуальной системе поиска интересных Вам товаров</li>
<li>Четкой системе внесения товаров в общую базу</li>
</ul>
</p>
</div>
<div id="footer">
	<%@include file="footer.jsp" %>
</div>
</div>

</body>
</html>
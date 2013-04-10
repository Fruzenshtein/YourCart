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
<h1><spring:message code="page.title.home" /></h1>
<div id="auth">
<ul>
<li><a href="#">Вход в систему</a></li>
<li><a href="#">Регистрация</a></li>
</ul>
</div>
</div>
<div id="menu">
<ul>
<li><a href="#">Главная страница</a></li>
<li><a href="#">О нас</a></li>
</ul>
</div>
<div id="content">
Контент
</div>
<div id="footer">
Copyright
</div>
</div>

</body>
</html>
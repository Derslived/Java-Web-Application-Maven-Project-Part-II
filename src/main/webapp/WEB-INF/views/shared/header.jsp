<%-- 
    Document   : header
    Created on : Jun 19, 2019, 10:42:37 PM
    Author     : Derslived
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.getContextPath()}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CIBT CRM!</h1>
        <ul>
            <li><a href="${SITE_URL}/register">Sign up</a></li>
            <li><a href="${SITE_URL}/login">Login</a></li>
        </ul>
    

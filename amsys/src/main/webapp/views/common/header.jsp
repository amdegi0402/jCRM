<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle} - jCRM</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="header">
        <div class="container">
            <nav class="nav">
                <a href="${pageContext.request.contextPath}/index.jsp" class="nav-link">ホーム</a>
                <a href="${pageContext.request.contextPath}/views/customers/list.jsp" class="nav-link">顧客管理</a>
                <a href="${pageContext.request.contextPath}/views/tasks/list.jsp" class="nav-link">タスク</a>
            </nav>
        </div>
    </header>
    <main class="container mt-3">
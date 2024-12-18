<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle} - jCRM</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <header>
        <div class="container">
            <div class="header-content">
                <c:choose>
                    <c:when test="${not empty sessionScope.employee}">
                        <div class="user-info">
                            <p>ログインユーザー: <c:out value="${employee.employeeName}" /></p>
                            <form action="./amsysFC" method="post" class="logout-form">
                                <button type="submit" name="buttonId" value="V101_00" class="btn btn-secondary">ログアウト</button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p>ゲストユーザー</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
    <main class="container">

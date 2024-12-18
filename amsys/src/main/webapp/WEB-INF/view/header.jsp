<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

<header>
    <div class="nav">
        <c:if test="${not empty sessionScope.loginUser}">
            <span>ログインユーザー: ${sessionScope.loginUser.userId}</span>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-secondary">ログアウト</a>
        </c:if>
    </div>
</header>
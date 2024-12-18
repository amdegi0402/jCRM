<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <jsp:include page="/WEB-INF/view/header.jsp" />
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>ログイン</h2>
            </div>
            <c:if test="${not empty errorMessage}">
                <div class="message message-error">
                    <c:out value="${errorMessage}" />
                </div>
            </c:if>
            <form method="post" action="login">
                <div class="form-group">
                    <label class="form-label">ユーザーID</label>
                    <input type="text" class="form-control" name="userId" required>
                </div>
                <div class="form-group">
                    <label class="form-label">パスワード</label>
                    <input type="password" class="form-control" name="password" required>
                </div>
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary">ログイン</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
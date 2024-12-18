<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン - jCRM</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body class="login-page">
    <div class="container">
        <div class="card login-card">
            <div class="card-header">
                <h1>ログイン</h1>
            </div>
            <form action="/amsys/amsysFC" method="post" class="login-form">
                <div class="form-group">
                    <label for="employeeNo" class="form-label">社員番号</label>
                    <input type="text" id="employeeNo" name="employeeNo" 
                           value="${param.employeeNo}" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">パスワード</label>
                    <input type="password" id="password" name="password" 
                           value="${param.password}" class="form-control" required>
                </div>
                <c:if test="${not empty requestScope.errorMessage}">
                    <div class="message message-error">
                        <c:out value="${requestScope.errorMessage}" />
                    </div>
                </c:if>
                <c:if test="${not empty requestScope.errorMessageList}">
                    <div class="message message-error">
                        <c:forEach var="message" items="${requestScope.errorMessageList}">
                            <p><c:out value="${message}" /></p>
                        </c:forEach>
                    </div>
                </c:if>
                <div class="form-group">
                    <button type="submit" name="buttonId" value="V101_03" 
                            class="btn btn-primary btn-block">ログイン</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
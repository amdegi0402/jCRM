<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>顧客検索</title>
    <jsp:include page="/WEB-INF/view/header.jsp" />
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>顧客検索</h2>
            </div>
            <c:if test="${not empty errorMessage}">
                <div class="message message-error">
                    <c:out value="${errorMessage}" />
                </div>
            </c:if>
            <form method="post" action="search">
                <div class="grid grid-2">
                    <div class="form-group">
                        <label class="form-label">顧客コード</label>
                        <input type="text" class="form-control" name="customerCode">
                    </div>
                    <div class="form-group">
                        <label class="form-label">顧客名</label>
                        <input type="text" class="form-control" name="customerName">
                    </div>
                </div>
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary">検索</button>
                    <button type="reset" class="btn btn-secondary">クリア</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
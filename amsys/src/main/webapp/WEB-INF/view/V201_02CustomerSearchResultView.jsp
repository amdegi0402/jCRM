<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>顧客検索結果</title>
    <jsp:include page="/WEB-INF/view/header.jsp" />
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>顧客検索結果</h2>
            </div>
            <c:if test="${not empty errorMessage}">
                <div class="message message-error">
                    <c:out value="${errorMessage}" />
                </div>
            </c:if>
            <c:if test="${not empty customerList}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>顧客コード</th>
                            <th>顧客名</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customerList}">
                            <tr>
                                <td>${customer.customerCode}</td>
                                <td>${customer.customerName}</td>
                                <td>
                                    <a href="edit?id=${customer.id}" class="btn btn-primary">編集</a>
                                    <a href="delete?id=${customer.id}" class="btn btn-danger">削除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <div class="mt-3">
                <a href="search" class="btn btn-secondary">検索画面に戻る</a>
            </div>
        </div>
    </div>
</body>
</html>
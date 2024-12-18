<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メインメニュー</title>
    <jsp:include page="/WEB-INF/view/header.jsp" />
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>メインメニュー</h2>
            </div>
            <div class="grid grid-3 mt-3">
                <a href="${pageContext.request.contextPath}/customer/search" class="btn btn-primary">顧客検索</a>
                <a href="${pageContext.request.contextPath}/customer/regist" class="btn btn-primary">顧客登録</a>
                <a href="${pageContext.request.contextPath}/customer/list" class="btn btn-primary">顧客一覧</a>
                <a href="${pageContext.request.contextPath}/report/monthly" class="btn btn-primary">月次集計</a>
                <a href="${pageContext.request.contextPath}/report/yearly" class="btn btn-primary">年次集計</a>
                <a href="${pageContext.request.contextPath}/report/items" class="btn btn-primary">商品別集計</a>
            </div>
        </div>
    </div>
</body>
</html>
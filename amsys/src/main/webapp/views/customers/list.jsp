<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="pageTitle" value="顧客一覧"/>
<%@ include file="../common/header.jsp" %>

<div class="card">
    <h2 class="card-title">顧客一覧</h2>
    <div class="mb-3">
        <a href="new.jsp" class="btn btn-primary">新規顧客登録</a>
    </div>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>会社名</th>
                <th>担当者</th>
                <th>電話番号</th>
                <th>メールアドレス</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.companyName}</td>
                    <td>${customer.contactPerson}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="edit.jsp?id=${customer.id}" class="btn btn-primary">編集</a>
                        <a href="javascript:void(0);" onclick="if(confirm('本当に削除しますか？')) location.href='delete.jsp?id=${customer.id}'" class="btn btn-danger">削除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../common/footer.jsp" %>
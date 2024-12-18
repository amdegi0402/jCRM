<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="pageTitle" value="得意先検索結果" />
<%@ include file="header.jsp" %>

<div class="card">
    <div class="card-header">
        <h2>得意先検索結果</h2>
    </div>
    <div class="card-body">
        <table class="table">
            <tr>
                <th>得意先コード</th>
                <td>${customer.custCode}</td>
            </tr>
            <tr>
                <th>得意先名</th>
                <td>${customer.custName}</td>
            </tr>
            <tr>
                <th>得意先ひらがな</th>
                <td>${customer.custKana}</td>
            </tr>
            <tr>
                <th>郵便番号</th>
                <td>${customer.custPost}</td>
            </tr>
            <tr>
                <th>住所</th>
                <td>${customer.custAdd}</td>
            </tr>
            <tr>
                <th>電話番号</th>
                <td>${customer.custTel}</td>
            </tr>
            <tr>
                <th>ファックス番号</th>
                <td>${customer.custFax}</td>
            </tr>
        </table>

        <div class="button-group mt-3">
            <form action="./amsysFC" method="post" style="display: inline-block; margin-right: 10px;">
                <button type="submit" name="buttonId" value="V201_01" class="btn btn-secondary">戻る</button>
            </form>
            <form action="./amsysFC" method="post" style="display: inline-block; margin-right: 10px;">
                <input type="hidden" name="custCode" value="${customer.custCode}">
                <button type="submit" name="buttonId" value="V204_01" class="btn btn-primary">変更</button>
            </form>
            <form action="./amsysFC" method="post" style="display: inline-block;">
                <input type="hidden" name="custCode" value="${customer.custCode}">
                <button type="submit" name="buttonId" value="V203_01" class="btn btn-danger">削除</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="pageTitle" value="得意先検索" />
<%@ include file="header.jsp" %>

<div class="card">
    <div class="card-header">
        <h2>得意先検索</h2>
    </div>
    <div class="card-body">
        <div class="mb-3">
            <form action="./amsysFC" method="post">
                <button type="submit" name="buttonId" value="V101_02" 
                        class="btn btn-secondary">メニュー画面へ戻る</button>
            </form>
        </div>

        <form action="./amsysFC" method="post" class="search-form">
            <div class="form-group">
                <label class="form-label">得意先コード</label>
                <input type="text" name="custCode" value="${param.custCode}" 
                       maxLength="6" class="form-control">
            </div>
            <div class="form-group">
                <button type="submit" name="buttonId" value="V201_02" 
                        class="btn btn-primary">検索</button>
            </div>
        </form>

        <c:if test="${not empty requestScope.errorMessage}">
            <div class="message message-error">
                <c:out value="${requestScope.errorMessage}" />
            </div>
        </c:if>
    </div>
</div>

<%@ include file="footer.jsp" %>
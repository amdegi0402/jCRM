<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="pageTitle" value="得意先登録" />
<%@ include file="header.jsp" %>

<div class="card">
    <div class="card-header">
        <h2>得意先登録</h2>
    </div>
    <div class="card-body">
        <form action="./amsysFC" method="post">
            <div class="form-group">
                <label class="form-label">得意先コード</label>
                <input type="text" name="custCode" value="${param.custCode}" maxLength="6" class="form-control">
            </div>
            <div class="form-group">
                <label class="form-label">得意先名</label>
                <input type="text" name="custName" value="${param.custName}" maxLength="50" class="form-control">
            </div>
            <div class="form-group">
                <label class="form-label">得意先ひらがな</label>
                <input type="text" name="custKana" value="${param.custKana}" maxLength="100" class="form-control">
            </div>
            <div class="form-group">
                <label class="form-label">郵便番号</label>
                <input type="text" name="custPost" value="${param.custPost}" maxLength="8" class="form-control">
            </div>
            <div class="form-group">
                <label class="form-label">住所</label>
                <input type="text" name="custAdd" value="${param.custAdd}" maxLength="100" class="form-control">
            </div>
            <div class="form-group">
                <label class="form-label">電話番号</label>
                <input type="text" name="custTel" value="${param.custTel}" maxLength="13" class="form-control">
            </div>
            <div class="form-group">
                <label class="form-label">ファックス番号</label>
                <input type="text" name="custFax" value="${param.custFax}" maxLength="13" class="form-control">
            </div>

            <div class="button-group mt-3">
                <button type="submit" name="buttonId" value="V101_02" class="btn btn-secondary">戻る</button>
                <button type="submit" name="buttonId" value="V202_02" class="btn btn-primary">登録</button>
            </div>
        </form>

        <c:if test="${not empty requestScope.errorMessage}">
            <div class="message message-error mt-3">
                <c:out value="${requestScope.errorMessage}" />
            </div>
        </c:if>
        <c:if test="${not empty requestScope.errorMessageList}">
            <div class="message message-error mt-3">
                <c:forEach var="message" items="${requestScope.errorMessageList}">
                    <p><c:out value="${message}" /></p>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>

<%@ include file="footer.jsp" %>
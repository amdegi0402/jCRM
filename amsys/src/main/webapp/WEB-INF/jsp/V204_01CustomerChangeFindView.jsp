
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!-- HTMLの作成 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>得意先変更画面</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div style="text-align: center">
		<h2>得意先変更</h2>
	</div>
	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<div style="text-align: right">
			<button type="submit" name="buttonId" value="V101_02"
				style="width: 200px">メニュー画面へ戻る</button>
		</div>
	</form>
	<form action="./amsysFC" method="post">
		<table>
			<tr>
				<td>得意先コード</td>
				<td><input type="text" name="custCode"
					value="${param.custCode}" maxLength="6" size="10"></td>
			</tr>
			<tr>
				<td><button type="submit" name="buttonId" value="V204_02">検索</button></td>
			</tr>
		</table>
	
	<!-- フォーム -->
	<c:if test="${not empty requestScope.customer}">
		
			<table>
				<tr>
					<td>得意先コード</td>
					<td><c:out value="${requestScope.customer.custCode}" /></td>
				</tr>
				<tr>
					<td>得意先名</td>
					<td><input type="text" name="custName" value="${requestScope.customer.custName}" maxLength="6" size="10"></td>
					
				</tr>
				<tr>
					<td>電話番号</td>
					<td><input type="text" name="telNo" value="${requestScope.customer.telNo}" maxLength="6" size="10"></td>
				</tr>
				<tr>
					<td>郵便番号</td>
					<td><input type="text" name="postalCode" value="${requestScope.customer.postalCode}" maxLength="6" size="10"></td>
				</tr>
				<tr>
					<td>住所</td>
					<td><input type="text" name="address" value="${requestScope.customer.address}" maxLength="6" size="10"></td>
				</tr>
				<tr>
					<td>割引率</td>
					<td><input type="number" name="discountRate" value="${requestScope.customer.discountRate}" maxLength="6" size="10"> %</td>
				</tr>
			</table>
			<br>
			<div>
				<button type="submit" name="buttonId" value="V204_03">変更</button>
			</div>
		</form>
	</c:if>
	<!-- エラーメッセージ -->
	<div style="text-align: center; color: red; font-weight: bold;">
		<%-- エラーメッセージがある場合、出力 --%>
		<c:out value="${requestScope.errorMessage}" />
		<c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}" />
			<br>
		</c:forEach>
	</div>
</body>
</html>

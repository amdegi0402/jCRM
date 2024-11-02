<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>得意先検索結果画面</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div>
		<h2>得意先検索結果</h2>
	</div>
	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<table border="1">
			<tr>
				<th>得意先コード</th>
				<th>得意先名</th>
				<th>電話番号</th>
				<th>郵便番号</th>
				<th>住    所</th>
				<th>割 引 率</th>
			</tr>
			
			<c:forEach var="customer" items="${customerList}" varStatus="status">
				<tr>
					<td><c:out value="${customer.custCode}" /></td>
					<td><c:out value="${customer.custName}" /></td>
					<td><c:out value="${customer.telNo}" /></td>
					<td><c:out value="${customer.postalCode}" /></td>
					<td><c:out value="${customer.address}" /></td>
					<td><c:out value="${customer.discountRate}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div>
			<button type="submit" name="buttonId" value="V101_02">メインメニューへ戻る</button>
		</div>
	</form>
</body>
</html>
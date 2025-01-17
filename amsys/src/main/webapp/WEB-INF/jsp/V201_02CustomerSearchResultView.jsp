
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
		<table>
			<tr>
				<td>得意先コード</td>
				<td><c:out
						value="${requestScope.customer.custCode}" /></td>
			</tr>
			<tr>
				<td>得意先名</td>
				<td><c:out
						value="${requestScope.customer.custName}" /></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><c:out
						value="${requestScope.customer.telNo}" /></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><c:out
						value="${requestScope.customer.postalCode}" /></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><c:out
						value="${requestScope.customer.address}" /></td>
			</tr>
			<tr>
				<td>割引率</td>
				<td><c:out
						value="${requestScope.customer.discountRate}" /> %</td>
			</tr>
		</table>
		<br>
		<div>
			<button type="submit" name="buttonId" value="V201_01">前画面へ戻る</button>
		</div>
	</form>
</body>
</html>

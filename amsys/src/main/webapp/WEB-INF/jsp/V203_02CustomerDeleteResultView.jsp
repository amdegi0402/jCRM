<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!-- HTMLの作成 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>得意先削除結果画面</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div style="text-align: center">
		<h2>得意先削除結果</h2>
		得意先を削除しました。
	</div>
	<!-- フォーム -->
	<form method="post" action="./amsysFC">
		<table border="1" style="margin: 0 auto">
			<tr>
				<td nowrap width="100">得意先コード</td>
				<td nowrap width="300"><c:out
						value="${requestScope.customer.custCode}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">得意先名</td>
				<td nowrap width="300"><c:out
						value="${requestScope.customer.custName}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">電話番号</td>
				<td nowrap width="300"><c:out
						value="${requestScope.customer.telNo}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">郵便番号</td>
				<td nowrap width="300"><c:out
						value="${requestScope.customer.postalCode}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">住所</td>
				<td nowrap width="300"><c:out
						value="${requestScope.customer.address}" /></td>
			</tr>
			<tr>
				<td nowrap width="100">割引率</td>
				<td nowrap width="300"><c:out
						value="${requestScope.customer.discountRate}" /> %</td>
			</tr>
		</table>
		<br>
		<div style="text-align:center">
			<button type="submit" name="buttonId" value="V203_01" style="width: 200px">前画面へ戻る</button>
		</div>
	</form>
</body>
</html>
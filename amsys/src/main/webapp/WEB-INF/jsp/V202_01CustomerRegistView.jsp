
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!-- HTMLの作成 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>得意先登録画面</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div style="text-align: center">
		<h2>得意先登録</h2>
	</div>
	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<div style="text-align: right">
			<button type="submit" name="buttonId" value="V101_02" style="width: 200px">メニュー画面へ戻る</button>
		</div>
	</form>
	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<table border="1" style="margin: 0 auto">
			<tr>
				<td nowrap width="100">得意先名</td>
				<td nowrap width="300"><input type="text"
					name="custName" maxLength="32" size="60" value="${param.custName}"></td>
			</tr>
			<tr>
				<td nowrap width="100">電話番号</td>
				<td nowrap width="300"><input type="text"
					name="telNo" maxLength="13" size="16" value="${param.telNo}"></td>
			</tr>
			<tr>
				<td nowrap width="100">郵便番号</td>
				<td nowrap width="300"><input type="text"
					name="postalCode" maxLength="8" size="10" value="${param.postalCode}"></td>
			</tr>
			<tr>
				<td nowrap width="100">住所</td>
				<td nowrap width="300"><input type="text"
					name="address" maxLength="40" size="80" value="${param.address}"></td>
			</tr>
			<tr>
				<td nowrap width="100">割引率</td>
				<td nowrap width="300"><input type="number"
					name="discountRate" maxLength="2" size="5" value="${param.discountRate}"> %</td>
			</tr>
		</table>
		<br>
		<div style="text-align:center">
			<button type="submit" name="buttonId" value="V202_02" style="width: 100px">登　　録</button>
		</div>
	</form>
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

<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>得意先検索画面</title>
<link rel="stylesheet" href="styles.css">
</head>

<body>
<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div>
		<h2>得意先検索</h2>
	</div>
	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<div>
			<button type="submit" name="buttonId" value="V101_02">メニュー画面へ戻る</button>
		</div>
	</form>
	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<table>
			<tr>
				<td>得意先コード</td>
				<td><input type="text" name="custCode"
					value="${param.custCode}" maxLength="6" size="10"></td>
			</tr>
			<tr>
				<td><button type="submit"
						name="buttonId" value="V201_02">検索</button></td>
			</tr>
		</table>
	</form>
	<!-- エラーメッセージ -->
	<div>
		<%-- エラーメッセージがある場合、出力 --%>
		<c:out value="${requestScope.errorMessage}" />
	</div>
</body>
</html>
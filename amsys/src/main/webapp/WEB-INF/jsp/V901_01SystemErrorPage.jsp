<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>システムエラー画面</title>
</head>
<body>
	<!-- 見出し -->
	<div style="text-align:center">
		<h2>システムエラー</h2>
	<c:out value="${requestScope.errorMessage}" />
	</div>
	<!-- フォーム -->
	<form action="./jsysFC" method="post">
	<div style="text-align:center">
		<button type="submit" name="buttonId" value="V901_01_01" style="width: 200px">ログイン画面へ</button>
	</div>
	</form>
</body>
</html>
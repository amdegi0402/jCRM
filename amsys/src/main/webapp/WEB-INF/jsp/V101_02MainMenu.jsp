
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!-- HTMLの作成 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>メインメニュー画面</title>
 <link rel="stylesheet" href="styles.css">
</head>

<body>
	<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div style="text-align: center">
		<h2>販売支援システム</h2>
		<h2>メインメニュー</h2>
	</div>

	<!-- フォーム -->
	<form action="./amsysFC" method="post">
		<table style="margin: 0 auto">
			<!-- ボタン -->
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V201_01"
						style="width: 200px">得意先検索</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V202_01"
						style="width: 200px">得意先追加</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V204_01"
						style="width: 200px">得意先変更</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V203_01"
						style="width: 200px">得意先削除</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V205_01"
						style="width: 200px">得意先一覧</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V301_01"
						style="width: 200px">月別集計</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V302_01"
						style="width: 200px">年別集計</button>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="buttonId" value="V303_01"
						style="width: 200px">商品集計</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

<!-- All Rights Reserved ,Copyright(c) Fujitsu Learning Media Limited -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品別受注集計画面</title>
<!-- <link rel="stylesheet" href="styles.css"> -->
<style>
/* styles.css */

/* ベースのリセット */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* 全体のフォントと背景 */
body {
    font-family: 'Helvetica Neue', Arial, 'Hiragino Kaku Gothic ProN', 'Hiragino Sans', Meiryo, sans-serif;
    background-color: #f5f7fa;
    color: #333;
    line-height: 1.6;
}

/* コンテナの中央寄せと幅設定 */
.container {
    width: 90%;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}

/* ヘッダーのスタイル */
header {
    background-color: #4a90e2;
    color: #fff;
    padding: 20px 0;
    text-align: center;
}

header h2 {
    font-size: 2em;
}

/* ボタンのスタイル */
button {
    background-color: #4a90e2;
    color: #fff;
    border: none;
    padding: 12px 24px;
    margin: 5px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1em;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #357ab8;
}

/* フォーム内の入力フィールド */
input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

/* テーブルのスタイル */
table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
}

table th, table td {
    padding: 12px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

table th {
    background-color: #eef1f5;
    font-weight: bold;
}

table tr:hover {
    background-color: #f1f3f5;
}

/* エラーメッセージのスタイル */
.error-message {
    text-align: center;
    color: red;
    font-weight: bold;
    margin-top: 20px;
}

/* メディアクエリでレスポンシブ対応 */
@media (max-width: 768px) {
    header h2 {
        font-size: 1.5em;
    }

    button {
        width: 100%;
        margin: 10px 0;
    }

    table, thead, tbody, th, td, tr {
        display: block;
    }

    table tr {
        margin-bottom: 15px;
    }

    table td {
        text-align: right;
        position: relative;
        padding-left: 50%;
    }

    table td::before {
        content: attr(data-label);
        position: absolute;
        left: 0;
        width: 45%;
        padding-left: 15px;
        font-weight: bold;
        text-align: left;
    }
}

</style>
</head>

<body>
	<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div>
		<h2>商品別受注集計画面</h2>
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
				<c:if test="${not empty requestScope}">
					<td>得意先名</td>
					<td><c:out value="${requestScope.customer.custName}" /></td>
				</c:if>
				
			</tr>
			<th>
			<td>
					<button type="submit" name="buttonId" value="V303_02">集計</button>
					<button type="submit" name="buttonId" value="V303_01">クリア</button>
				</td>
			</th>
		</table>
	</form>
	<form action="./amsysFC" method="post">
		<table border="1">
<c:if test="${not empty requestScope.sumTotal}">
		<tr>
			<th>商品コード</th>
			<th>商品名</th>
			<th>合計数量</th>
			<th>単語</th>
			<th>商品別合計金額</th>
			</tr>
	
			<c:forEach var="orderItem" items="${orderList}"
				varStatus="status">
			
				<tr>
					<td><c:out value="${orderItem.itemCode}" /></td>
					<td><c:out value="${orderItem.itemName}" /></td>
					<td><c:out value="${orderItem.totalAmount}" /></td>
					<td><c:out value="${orderItem.price}" /></td>
					<td><c:out value="${orderItem.totalPrice}" /></td>
				</tr>

			</c:forEach>
			
				<tr>
					<td colspan="2">総 計</td>
					<td><c:out value="${requestScope.sumTotal}" /></td>
				</tr>
			</c:if>
		</table>
		<div>
			<button type="submit" name="buttonId" value="V101_02">メインメニューへ戻る</button>
		</div>
	</form>
	<!-- エラーメッセージ -->
	<!-- エラーメッセージ -->
	<div style="text-align: center; color: red; font-weight: bold;">
		<%-- エラーメッセージがある場合、出力 --%>
		<c:out value="${requestScope.errorMessage}" />
	</div>
</body>
</html>
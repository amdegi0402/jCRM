
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>月別受注集計画面</title>
<link rel="stylesheet" href="styles.css">
</head>

<body>
	<!-- ヘッダー部分をインクルード -->
	<jsp:include page="header.jsp" />
	<!-- 見出し -->
	<div>
		<h2>月別受注集計画面</h2>
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
				<td>集計する月</td>
				   <!-- 年のプルダウン -->
                <select name="year">
                    <option value="2020" <c:if test="${param.year == '2020'}">selected</c:if>>2020</option>
                    <option value="2021" <c:if test="${param.year == '2021'}">selected</c:if>>2021</option>
                    <option value="2022" <c:if test="${param.year == '2022'}">selected</c:if>>2022</option>
                    <option value="2023" <c:if test="${param.year == '2023'}">selected</c:if>>2023</option>
                    <option value="2024" <c:if test="${param.year == '2024'}">selected</c:if>>2024</option>
                    <option value="2025" <c:if test="${param.year == '2025'}">selected</c:if>>2025</option>
                    <!-- 必要に応じて追加 -->
                </select>年 

                <!-- 月のプルダウン -->
                <select name="month">
                    <option value="1" <c:if test="${param.month == '1'}">selected</c:if>>1</option>
                    <option value="2" <c:if test="${param.month == '2'}">selected</c:if>>2</option>
                    <option value="3" <c:if test="${param.month == '3'}">selected</c:if>>3</option>
                    <option value="4" <c:if test="${param.month == '4'}">selected</c:if>>4</option>
                    <option value="5" <c:if test="${param.month == '5'}">selected</c:if>>5</option>
                    <option value="6" <c:if test="${param.month == '6'}">selected</c:if>>6</option>
                    <option value="7" <c:if test="${param.month == '7'}">selected</c:if>>7</option>
                    <option value="8" <c:if test="${param.month == '8'}">selected</c:if>>8</option>
                    <option value="9" <c:if test="${param.month == '9'}">selected</c:if>>9</option>
                    <option value="10" <c:if test="${param.month == '10'}">selected</c:if>>10</option>
                    <option value="11" <c:if test="${param.month == '11'}">selected</c:if>>11</option>
                    <option value="12" <c:if test="${param.month == '12'}">selected</c:if>>12</option>
                </select>月
				<td><button type="submit" name="buttonId" value="V301_02">集計</button>
					<button type="submit" name="buttonId" value="V301_01">クリア</button>
				</td>
			</tr>
		</table>
	</form>
	<form action="./amsysFC" method="post">
		<table border="1">
<c:if test="${not empty requestScope.sumTotal}">
		<tr>
			<th>得意先コード</th>
			<th>得意先名</th>
			<th>得意先別合計金額</th>
			</tr>
	
			<c:forEach var="orderCustomer" items="${orderList}"
				varStatus="status">
			
				<tr>
					<td><c:out value="${orderCustomer.custCode}" /></td>
					<td><c:out value="${orderCustomer.custName}" /></td>
					<td><c:out value="${orderCustomer.totalPrice}" /></td>
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
		<c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}" />
			<br>
		</c:forEach>
	</div>
</body>
</html>

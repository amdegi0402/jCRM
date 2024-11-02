<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<header>
	<c:choose>
		<c:when test="${not empty sessionScope.employee}">
			<p>
				ログインユーザー:
				<c:out value="${employee.employeeName}" />
			</p>
			<p>
			<form action="./amsysFC" method="post">
				<div>
					<button type="submit" name="buttonId" value="V101_00">ログアウト</button>
				</div>
			</form>
			</p>
		</c:when>
		<c:otherwise>
			<p>ゲストユーザー</p>
		</c:otherwise>
	</c:choose>
</header>
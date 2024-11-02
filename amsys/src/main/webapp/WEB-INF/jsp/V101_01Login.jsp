<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>モダンでシンプルなログイン</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 1.5rem;
        }
        .input-group {
            margin-bottom: 1rem;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #555;
        }
        input[type="text"],
        input[type="password"],
        button {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 1rem;
            box-sizing: border-box;
        }
        button {
            background-color: #1877f2;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 1rem;
        }
        button:hover {
            background-color: #166fe5;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>ログイン</h2>
        <form action="/amsys/amsysFC" method="post"">
            <div class="input-group">
                <label for="employeeNo">社員番号</label>
                <input type="text" id="employeeNo" name="employeeNo" value="${param.employeeNo}" required>
            </div>
            <div class="input-group">
                <label for="password">パスワード</label>
                <input type="password" id="password" name="password" value="${param.password}" required>
            </div>
            <c:out value="${requestScope.errorMessage}" />
            <c:forEach var="message" items="${requestScope.errorMessageList}">
			<c:out value="${message}" />
			<br>
		</c:forEach>
            <button type="submit" name="buttonId" value="V101_03">ログイン</button>
        </form>
        
    </div>
    	
</body>
</html>
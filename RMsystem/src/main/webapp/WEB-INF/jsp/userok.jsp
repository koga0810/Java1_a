<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

 	<head>

 		<meta charset="UTF-8">
 		<title>ユーザー登録完了</title>
 		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	</head>


	<body>
	<div class="button-container">
		<h1>登録が完了しました！</h1>
    	<p>登録された情報:</p>
    	<p>ID: <%= session.getAttribute("username") %></p>
    	<p>パスワード: ＊＊＊＊＊＊＊＊</p>
    	
		<form action="SecretariatServlet" method="post">
		<input type="submit" value=戻る>
		</form>
	</div>
		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>新規ユーザー登録</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">

	</head>


	<body>

		<h1>新規ユーザー登録</h1>
		
		<div class="button-container">
		<form action="UserokServlet" method="post">
      
			<label for="username">　　ユーザーID:</label>
				<input type="text" id="username" name="username" placeholder="入力" required><br><br>
        
			<label for="password">パスワード登録:</label>
				<input type="password" id="password" name="password"placeholder="半角英数字6文字以上20文字以内" required minlength="6" maxlength="20"><br><br>
        
			<label for="password">パスワード確認:</label>
				<input type="password" id="password2" name="password"placeholder="パスワード確認" required minlength="6" maxlength="20"><br><br>
        
        <div class="button-container">
        
        <form action="UserokServlet" method="post" class="form-inline">
		<input type="submit" value="登録">
		</form>
		
		<form action="SecretariatServlet" method="post" class="form-inline">
		<input type="submit" value=戻る>
		</form>
		
        </div>



	</body>


</html>
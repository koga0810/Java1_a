<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>


 	<head>

 		<meta charset="UTF-8">
 		<title>ユーザー登録完了</title>

	</head>


	<body>
		<h1>登録成功しました。</h1>
    	<p>登録された情報:</p>
    	<p>ID: <%= session.getAttribute("username") %></p>
    	<p>パスワード: ＊＊＊＊＊＊＊＊</p>
    	
    	<input type="submit" value=戻る>
	</body>
</html>
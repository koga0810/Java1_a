
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>

<html>

	<head>

		<meta charset="UTF-8">
		<title>ログイン画面</title>

	</head>

	<body>
    
		<h1>ＲＭシステム</h1>
   
		<form action="LoginServlet" method="post">
			<input type="text" name="name" placeholder="ユーザーID"><br>
			<input type="password" name="pass" placeholder="パスワード"><br>
			<input type="submit" value="ログイン">
		</form>
   
	</body>


</html>
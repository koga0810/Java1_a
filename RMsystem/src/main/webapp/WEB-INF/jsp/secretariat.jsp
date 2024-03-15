
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>


	<head>

		<meta charset="UTF-8">
		<title>事務局画面</title>

	</head>

	<body>
    
		<h1>事務局画面</h1>
    
		<form action="備品管理の画面" method="post">
			<input type="submit" id="bihin" value="備品管理">
		</form>
      
      
		<form action="ユーザー情報の画面" method="post">
			<input type="submit" id="user" value="ユーザー情報"> 
		</form>
      
          
		<form action="クラスページの画面" method="post">
			<input type="submit" id="class" value="クラスページ">
		</form>
          
          
		<footer>
			<form action="新規ユーザー登録の画面" method="post">
				<input type="submit" value="新規ユーザー登録">
			</form>
		</footer>
          
     
       

	</body>
    
    
    
</html>
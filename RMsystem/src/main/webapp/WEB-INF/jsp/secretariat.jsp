<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>事務局画面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">	
	
	</head>

	<body>
    
		<h1>事務局画面</h1>
		
		<div class="card">
		<form action="EquipmentServlet" method="post" class="card-action">
			<input type="submit" id="bihin" value="備品管理">
		</form>
		<span class="card-message">備品の在庫確認や数量の変更を行います。</span>
		</div>
		
		<div class="card">
		<form action="AccountServlet" method="post" class="card-action">
		<input type="submit" id="user" value="ユーザー情報"> 
		</form>
		<span class="card-message">登録済のユーザー情報を管理します。</span>
		</div>
		
		<div class="card">
		<form action="ClassManagementServlet" method="post" class="card-action">
		<input type="submit" id="class" value="クラスページ">
		</form>
		<span class="card-message">各クラスのページを編集します。</span>
		</div>
          
		<footer>
		<div class="card">
		<form action="UserServlet" method="post" class="card-action">
		<input type="submit" value="新規ユーザー登録">
		</form>
		<span class="card-message">新規ユーザー登録画面へ</span>
		</div>
		</footer>
          
     
       

	</body>
    
    
    
</html>
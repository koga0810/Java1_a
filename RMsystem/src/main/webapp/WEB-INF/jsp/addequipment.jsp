<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
    	<meta charset="UTF-8">
    	<title>新規備品登録</title>
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	</head>
	
	<body>
    	<h1>新規備品登録</h1>
    	
    		<form action="Add" method="post">
    		
        		<label for="itemName">品名:</label>
        		<input type="text" id="itemName" name="itemName" required><br><br>
        
        		<label for="quantity">在庫数:</label>
        		<input type="number" id="quantity" name="quantity" required><br><br>
        
        		<label for="location">場所:</label>
        		<input type="text" id="location" name="location" required><br><br>
        
        		<label for="updaterId">最終更新者ID:</label>
        		<input type="text" id="updaterId" name="updaterId" required><br><br>
        
        		<input type="submit" value="登録">
    		</form>
	</body>
	
</html>

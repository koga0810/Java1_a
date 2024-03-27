<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>ユーザー管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	</head>

	<body>
	
	<div class="table-container">

    <h1>ユーザー情報</h1>

		<table border="1">
  			
  			<thead>
    			<tr>
      			<th scope="col">ＩＤ</th>
      			<th scope="col">区分</th>
      			<th scope="col">氏名</th>
      			<th scope="col">フリガナ</th>
      			<th scope="col">パスワード</th>
      			<th scope="col">住所</th>
      			<th scope="col">年齢</th>
      			<th scope="col">クラス</th>
      			<th scope="col">入校日</th>
      			<th scope="col">退校日</th>
      			<th scope="col">欠席日数</th>
      			<th scope="col">最終更新日</th>
    			</tr>
  			</thead>
  			
  			<tbody>
  			
  			 <c:forEach var="user" items="${users}">
    			<tr>
    				<td>${user.id}</td>
      				<td>${user.division}</td>
      				<td>${user.name}</td>
      				<td>${user.kana}</td>
      				<td>${user.pass}</td>
      				<td>${user.address}</td>
      				<td>${user.age}</td>
      				<td>${user.classId}</td>
      				<td>${user.admissionDate}</td>
      				<td>${user.graduationDate}</td>
      				<td>${user.absentDay}</td>
      				<td>${user.lastUpdated}</td>
      				
      			
    			</tr>
    			
    		</c:forEach>
    
    			
  			</tbody>
  
  			
		</table>
		<br>
		<div class="button-container">
		<form action="SecretariatServlet" method="post">
		<input type="submit" value=戻る>
		<input type="submit" value=編集>
		<form action="AccountServlet" method="post">
		<input type="submit" value=更新>
		</form>
		</div>

	</body>
</html>
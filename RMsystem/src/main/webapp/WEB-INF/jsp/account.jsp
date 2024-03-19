<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    			<tr>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
    			</tr>
    
    			
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
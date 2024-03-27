<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>備品管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	</head>

	<body>
<div class="table-container">

    <h1>備品在庫管理</h1>
    
    <table border="1">
        
        <thead>
            <tr>
                <th scope="col">品番</th>
                <th scope="col">品名</th>
                <th scope="col">在庫数</th>
                <th scope="col">最終更新者ID</th>
                <th scope="col">最終更新日</th>
            </tr>
        </thead>
    		
  		</tbody>
  			
  			<c:forEach var="equipment" items="${equipments}">
        	
        	<tr>
            <td>${equipment.id}</td>
            <td>${equipment.itemName}</td>
            <td>${equipment.quantity}</td>
            <td>${equipment.updaterId}</td>
            <td>${equipment.lastUpdated}</td>
        	</tr>
        	
    		</c:forEach>
  
  			<tfoot>
    			
    			</tr>
  			</tfoot>
		</table>
		</div>
		<br>
<div class="button-container">
    <form action="SecretariatServlet" method="post" class="form-inline">
        <input type="submit" value="戻る" class="button-inline">
    </form>
    
    <!-- 編集ボタンの処理先が未定義のため、適切なサーブレットに設定してください -->
    <form action="EditServlet" method="post" class="form-inline">
        <input type="submit" value="編集" class="button-inline">
    </form>

    <form action="EquipmentServlet" method="post" class="form-inline">
        <input type="submit" value="更新" class="button-inline">
    </form>
</div>


	</body>
</html>
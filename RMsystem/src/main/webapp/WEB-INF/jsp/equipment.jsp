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
    		
        <%-- 備品データの動的表示処理 --%>
        <c:forEach var="equipment" items="${equipments}">
            <tr>
                <td><c:out value="${equipment.id}"/></td>
                <td><c:out value="${equipment.itemName}"/></td>
                <td><c:out value="${equipment.quantity}"/></td>
                <td><c:out value="${equipment.updaterId}"/></td>
                <td><c:out value="${equipment.lastUpdated}"/></td>
                <td><button onclick="editRow(this)">編集</button></td>
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

<script type="text/javascript">
function editRow(button) {
    var row = button.parentNode.parentNode;
    var cells = row.getElementsByTagName('td');

    // 各セルについて編集可能なフィールドに変更
    for (var i = 0; i < cells.length - 2; i++) { // 最後の2セル（編集ボタンがあるセルと状態表示用のセル）を除く
        var value = cells[i].innerText;
        cells[i].innerHTML = '<input type="text" value="' + value + '">';
    }

    // 編集ボタンを「保存」ボタンに切り替え
    button.innerText = '保存';
    button.setAttribute('onclick', 'saveRow(this)');
}

function saveRow(button) {
    var row = button.parentNode.parentNode;
    var inputs = row.getElementsByTagName('input');
    
    // TODO: ここでinputsの値を取得してサーバーに送信する処理を実装

    // ページの再読み込みなどで変更を反映
    location.reload();

    function saveRow(button) {
        var row = button.parentNode.parentNode;
        var cells = row.getElementsByTagName("input"); // 編集用テキストボックスを取得
        var data = {
            id: row.getAttribute("data-id"), // 行にdata-id属性としてIDを設定しておく
            itemName: cells[0].value,
            quantity: cells[1].value
        };

        fetch('EquipmentUpdateServlet', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // 成功した場合の処理（ページの再読み込みなど）
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    
}</script>


	</body>
</html>
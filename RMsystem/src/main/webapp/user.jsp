<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>


	<head>

		<meta charset="UTF-8">
		<title>新規ユーザー登録</title>

	</head>


	<body>

		<h1>新規ユーザー登録</h1>

		<form action="ユーザー登録の画面" method="post">
      
			<label for="username">ユーザーID:</label>
				<input type="text" id="username" name="username" placeholder="入力" required><br><br>
        
			<label for="password">パスワード登録:</label>
				<input type="password" id="password" name="password"placeholder="半角英数字6文字以上20文字以内" required minlength="6" maxlength="20"><br><br>
        
			<label for="password">パスワード確認:</label>
				<input type="password" id="password2" name="password"placeholder="パスワード確認" required minlength="6" maxlength="20"><br><br>
        
				<input type="submit" value="登録">
				<input type="submit" value="戻る">
      
		</form>



	</body>


</html>
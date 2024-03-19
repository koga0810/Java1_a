<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<h1>ログイン画面</h1>

<% if (request.getAttribute("errorMessage") != null) { %>
    <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
<% } %>

<div class="button-container">
<form action="LoginServlet" method="post">
    <input type="text" name="name" placeholder="ユーザーID"><br>
    <br>
    <input type="password" name="pass" placeholder="パスワード"><br>
    <br>
    <br>
    <input type="submit" value="ログイン">
</form>
</div>

</body>
</html>

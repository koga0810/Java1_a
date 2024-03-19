<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>クラス管理画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>

<h1>クラスページ</h1>

<div class="layout">
    <!-- 左側エリア -->
    <div class="left-column">
        <!-- 画像エリア -->
        <div class="image-display">
            <h2>クラスの画像</h2>
            <img src="${pageContext.request.contextPath}/resources/img/example.jpg" alt="クラス画像" class="rounded-blur-image">
        </div>
        
        <!-- カレンダーエリア -->
        <div id="monthAndYear"></div>
    <div id="calendar"></div>
        <div class="calendar">
    <div class="calendar-header">
        <button onclick="changeMonth(-1)">&#10094;</button>
        <span class="month-year"></span>
        <button onclick="changeMonth(1)">&#10095;</button>
    </div>
    <div id="calendar"></div>
</div>

    <!-- 右側メッセージエリア -->
    <div class="message-area">
        <h2>メッセージエリア</h2>
        <form action="MessageServlet" method="post">
            <textarea name="message" rows="4" placeholder="メッセージを入力"></textarea>
            <input type="submit" value="送信">
        </form>
        <% if (request.getAttribute("postedMessage") != null) { %>
            <p>最新のメッセージ: <%= request.getAttribute("postedMessage") %></p>
        <% } %>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/calendar.js"></script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <title>도서 관리 앱</title>
</head>
<body>
<div class="container w-75 mt-5 mx-auto">
    <div class="mb-3">
        <h2>${books.title}</h2>
        <p><strong>ID:</strong> ${books.id} | <strong>작성자:</strong> ${books.writer} | <strong>생성일:</strong> ${books.date}</p>
    </div>
    <hr>
    <div class="card w-75 mx-auto">
        <img class="card-img-top" src="data:image/jpeg;base64,${books.imageData}">
    </div>
    <hr>
    <a href="javascript:history.back()" class="btn btn-primary"> Back </a>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br>
<a href="searchMember">DoGet 방식 요청</a>
<br>
<form action="memberRegister" method="post">
  <label>아이디: </label>
  <input type="text" name="userId">
  <br>
  <label>비밀번호: </label>
  <input type="password" name="password">
  <br>
  <label>이름: </label>
  <input type="text" name="name">
  <br>
  <button type="submit">가입하기</button>
</form>
</body>
</html>
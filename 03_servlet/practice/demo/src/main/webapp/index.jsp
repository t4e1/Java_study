<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>"서블릿&JDBC 복습 - 회원 가입 / 조회 테스트 !!!!"</h1>
<br>
<form action="member/viewer" method="get">
  <a>선택한 회원 조회</a>
  <br>
  <label>아이디: </label>
  <input type="text" name="userId">
  <br>
  <label>비밀번호: </label>
  <input type="password" name="password">
  <br>
  <button type="submit">조회</button>
</form>
<br>
<form action="member/register" method="post">
  <a>신규 회원 가입</a>
  <br>
  <label>아이디: </label>
  <input type="text" name="userId">
  <br>
  <label>비밀번호: </label>
  <input type="password" name="password">
  <br>
  <label>이름: </label>
  <input type="text" name="name">
  <br>
  <button type="submit">가입</button>
</form>
</body>
</html>
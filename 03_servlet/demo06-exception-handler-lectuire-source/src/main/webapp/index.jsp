<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1 align="center">Exception Handler</h1>

<!--
  Exception 핸들링 해보기
  1. web.xml을 통해 에러 상태 코드 발생 시 어떤 서블릿으로 요청할 지 url 경로 설정해 보기
  2. 모든 에러에 대해 페이지를 동적으로 처리 할 페이지를 request의 attribue에 담긴 값을
     활용하여 동작 엔터페이스를 응답해 보기
-->
<!-- ul>(li>a)*2 -->
<ul>
  <li><a href="show404error">404 에러 확인</a></li>
  <li><a href="show500error">500 에러 확인</a></li>
</ul>
</body>
</html>
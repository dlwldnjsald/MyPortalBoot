<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Home: Join Success</title>
    <link rel="stylesheet" href='<c:url value="/css/users.css" />' />
  </head>
  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="join-form">
        <h1>Join Success</h1>
        <p>가입에 성공하셨습니다</p>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>

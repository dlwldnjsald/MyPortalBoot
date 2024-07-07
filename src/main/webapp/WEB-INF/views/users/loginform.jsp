<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Home: Login</title>
    <link rel="stylesheet" href='<c:url value="/css/users.css" />' />
  </head>
  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="login-form">
        <h1>Login</h1>
        
        
        <c:if test="${ not empty requestScope.errorMsg }">
          <p style="color:red; fonte-weight:bold;">${ requestScope.errorMsg }</p>
        </c:if>
        <form method="POST" action="<c:url value='/users/login'/>">
          <label for="email">이메일</label>
          <input type="text" name="email" /><br />
          <label for="password">Password</label>
          <input type="password" name="password" /><br />
          <input type="submit" value="Sign in" />
        </form>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>

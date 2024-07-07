<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Home: Join Form</title>
    <link rel="stylesheet"href='<c:url value="/css/users.css" />' />
  </head>
  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="join-form">
        <h1>Join Form</h1>
        
        <c:if test="${ not empty requestScope.errorMsg }">
          <p style="color:red; font-weight:bold;">${ requestScope.errorMsg }</p>
        </c:if>
        <form:form modelAttribute="userVO" method="POST" action="${pageContext.request.contextPath}/users/join">
          <label for="name">이름</label>
          <form:input path="name"/><br />
          
          <spring:hasBindErrors name="userVO">
             <c:if test="${errors.hasFieldErrors('name') }">
               <strong>
                <spring:message
                  code="${errors.getFieldError( 'name' ).codes[0] }" 
                  text="${errors.getFieldError( 'name' ).defaultMessage }" />
               </strong><br />
             </c:if>
          </spring:hasBindErrors>
          <br />
          <label for="password">암호</label>
          <form:password path="password"/><br />
          <form:errors path="password" cssClass="error" /><br />
          
          <label for="email">이메일</label>
          <form:input path="email"/><br />
          <form:errors path="email" cssClass="error" />
          <br />
          <input type="button" id="check-email" data-target="<c:url value = '/users/checkEmail' />" value = "이메일 중복확인" />
          <input type="hidden" name="emailCheck" value="none" />
          
          <br /><br />
          <span>성별</span>
          <form:radiobutton path="gender" value="M" id="genderM" />
          <label for="genderM">남성</label>
          
          <form:radiobutton path="gender" value="F" id="genderF" />
          <label for="genderF">여성</label><br/>
          <form:errors path="gender" cssClass="error" />
          
          
          <br/>
          <label for="agree">약관동의</label>
          <input type="checkbox" name="agree" id="agree" value="none" />
          
          <input type="submit" value="Sign up" />
        </form:form>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
    <script type="text/javascript" src="<c:url value = '/javascript/users.js' />" ></script>
  </body>
</html>

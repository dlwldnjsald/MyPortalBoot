<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div id="header">
  <h1>sashin92's Page</h1>
  <div class="button-container">
      <c:if test="${ not empty requestScope.errorMsg }">
        <p style="color:red; fonte-weight:bold;">${ requestScope.errorMsg }</p>
      </c:if>
    <ul>
      <c:choose>
        <c:when test="${ empty sessionScope.authUser }">
          <li><a href="<c:url value="/users/join" />">회원가입</a></li>
          <li><a href="<c:url value="/users/login" />">로그인</a></li>   
        </c:when>
        <c:otherwise>
          <li><a href="<c:url value="/users/logout" />">로그아웃</a></li>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
</div>

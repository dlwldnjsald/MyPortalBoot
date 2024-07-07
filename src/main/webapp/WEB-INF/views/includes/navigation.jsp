<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<div id="navigation">
  <ul>
    <li><a href="<c:url value='/' />">My Home</a></li>
    <li><a href="<c:url value='/guestbook' />">방명록</a></li>
    <li><a href="<c:url value='/board' />">게시판</a></li>
    <li><a href="<c:url value='/fileupload' />">파일업로드</a></li>
  </ul>
</div>

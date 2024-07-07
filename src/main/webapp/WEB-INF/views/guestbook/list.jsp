<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>방명록</title>
    <link type="text/css" rel="stylesheet" href='<c:url value="/css/guestbook.css" />' />
  </head>

  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="content">
        <div id="guestbook">
          <form action="<c:url value='/guestbook/write' />" method="POST">
            <table>
              <tr>
                <td>이름</td>
                <td><input type="text" name="name" /></td>
                <td>비밀번호</td>
                <td><input type="password" name="password" /></td>
              </tr>
              <tr>
                <td colspan="4">
                  <textarea name="content" cols="50" rows="5"></textarea>
                </td>
              </tr>
              <tr>
                <td colspan="4" align="right">
                  <input type="submit" VALUE=" 확인 " />
                </td>
              </tr>
            </table>
          </form>
          <br />
          
          <c:forEach items="${ requestScope.guestbookList }" var="vo" varStatus="status">
            <table>
              <tr>
                <td>[${ vo.no }] ${ status.count } 번 째 게시글</td>
                <td>${ vo.name }</td>
                <td>${ vo.regDate }</td>
                <td>
                  <a href="<c:url value='/guestbook/delete/${ vo.no }' />">삭제</a>
                </td>
              </tr>
              <tr>
                <td colspan="4">${ vo.content }</td>
              </tr>
            </table>
            <br />
          </c:forEach>
        </div>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>

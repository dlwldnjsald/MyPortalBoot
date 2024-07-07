<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

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
          <form action="<c:url value='/guestbook/delete' />" method="POST">
            <input type="hidden" name="no" value="${ no }">
            <table>
              <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password" /></td>
                <td><input type="submit" value="확인" /></td>
                <td>
                  <a href="<c:url value='/guestbook' />">돌아가기</a>
                </td>
              </tr>
            </table>
          </form>
        </div>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>

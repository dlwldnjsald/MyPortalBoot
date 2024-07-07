<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>sashin92's Page</title>
<link type="text/css" rel="stylesheet"
  href='<c:url value="/css/board.css" />' />
</head>
<body>
  <div id="container">
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    <jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

    <div id="content">
      <div id="board" class="board-form">

        <table border="1" width="640" class="tbl-ex">
          <tr>
            <td colspan="2"><h3>게시판</h3></td>
          </tr>
          <tr>
            <th colspan="2">글보기</th>
          </tr>
          <tr>
            <td>제목</td>
            <td>${ selectedBoard.title }</td>
          </tr>
          <c:if test="${ not empty boardFile }">
          <tr>
            <td>첨부된 파일</td>
            <td>
              <div class="upload-image">
                <img alt="첨부파일" src="<c:url value='/upload/${ boardFile.name }' />" />
              </div>
            </td>
          </tr>
          </c:if>
          <tr>
            <td>내용</td>
            <td>
              <div>${ selectedBoard.content }</div>
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <a href="<c:url value="/board" />">글목록</a>
              <a href="<c:url value="/board/modify" />/${selectedBoard.no}">글수정</a>
            </td>
          </tr>
        </table>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
  </div>

</body>
</html>

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
        <form method="post" action="" enctype="multipart/form-data">
          <table border="1" width="640" class="tbl-ex">
            <tr>
              <td colspan="2"><h3>게시판</h3></td>
            </tr>
            <tr>
              <th colspan="2">글쓰기</th>
            </tr>
            <tr>
              <td colspan="2">첨부 파일 1 <input type="file" name="file1" />
            </tr>
            <tr>
              <td>제목</td>
              <td><input type="text" name="title" value=""></td>
            </tr>
            <tr>
              <td>내용</td>
              <td><textarea id="content" name="content"></textarea>
              </td>
            </tr>
            <tr>
              <td colspan="2"><a href="<c:url value="/board" />">취소</a> <input
                type="submit" value="등록"></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
  </div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link type="text/css" rel="stylesheet"
  href='<c:url value="/css/home.css" />' />
<title>sashin92's Page</title>
</head>
<body>
  <div id="container">
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    <jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

    <div id="content">
      <h1>파일</h1>

      <img alt="uploaded file" src="<c:url value='/upload/${ imageFileName }' />" />
      <br/>

      <a href="<c:url value='/fileupload/form' />">업로드 양식</a>
    
    </div>
  <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
  </div>
</body>
</html>
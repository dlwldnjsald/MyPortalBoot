<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<jsp:include page="/WEB-INF/views/includes/start.jsp" />
  <div id="site-introduction">
    <!-- content 영역 -->
    <h2>
      환영합니다
      <c:if test="${ not empty authUser }">
        <c:out value=" ${ sessionScope.authUser.name }님." />
      </c:if>
    </h2>
    <p>세션을 이용한 로그인 유지기능까지 구현했습니다.</p>
    <p>scriptlet을 jstl로 대체했습니다.</p>
    <p>Spring으로 대체했습니다.</p>
    <p>게시판 일부 구현했습니다.</p>
  </div>
<jsp:include page="/WEB-INF/views/includes/end.jsp" />
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>sashin92's Page</title>
<link type="text/css" rel="stylesheet"
  href='<c:url value="/css/home.css" />' />
</head>
<body>
  <div id="container">
    <c:import url="/WEB-INF/views/includes/header.jsp">
      <c:param name="param1" value="value1" />
      <c:param name="param2" value="value2" />
    </c:import>

    <jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

    <div id="content">
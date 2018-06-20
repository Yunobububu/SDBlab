<%--
  Created by IntelliJ IDEA.
  User: lvjinke
  Date: 2018/6/14
  Time: 上午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="${pageContext.request.contextPath}/resources"/>
<c:set var="currentTime" value="${LocalDateTime.now()}"/>
<c:set var="today" value="${LocalDate.now()}"/>
<c:set var="MonNine" value="${LocalDateTime.now()}"/>
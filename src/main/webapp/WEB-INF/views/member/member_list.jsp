<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>회원 목록</title>
<%@ include file="member_header.jsp" %>
</head>
<body>
<%@ include file="member_menu.jsp" %>
	<input type="button" value="회원등록" onclick="location.href='${path}/member/write.do'">
    <h2>회원 목록</h2>
    <h2>${msg}</h2>
    <table border="1" width="700px">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>나이</th>
        </tr>
        <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.id}</td>
            <td>${row.name}</td>
            <td>${row.age}</td>
           
        </tr>
        </c:forEach>
    </table>
</body>
</html>

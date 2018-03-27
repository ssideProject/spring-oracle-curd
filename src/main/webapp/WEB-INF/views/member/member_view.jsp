<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>회원정보 상세 페이지</title>
	<%@ include file="member_header.jsp" %>
	
	<script>
    $(document).ready(function(){
        $("#btnUpdate").click(function(){
            // 확인 대화상자    
            if(confirm("수정하시겠습니까?")){
                document.form1.action = "${path}/member/update.do";
                document.form1.submit();
            }
        });
    });
    $(document).ready(function(){
        $("#btnDelete").click(function(){
            // 확인 대화상자 
            if(confirm("삭제하시겠습니까?")){
                document.form1.action = "${path}/member/delete.do";
                document.form1.submit();
            }
        });
    });
</script>
	
</head>
<body>
	<%@ include file="member_menu.jsp" %>
	    <h2>회원정보 상세</h2>
	    <form name = "form1" method ="post">
	    	<table border="1" width="400px">
            <tr>
                <td>아이디</td>
                 <!-- id는 수정이 불가능하도록 readonly속성 추가 -->
                <td><input name="id" value="${dto.id}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="passwd" ></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input name="name" value="${dto.name}"></td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input name="age" value="${dto.age}"></td>
            </tr>
            <tr>
                <td>회원가입일자</td>
                <td>
                    <fmt:formatDate value="${dto.reg}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr>
                <td>회원정보 수정일자</td>
                <td>
                    <fmt:formatDate value="${dto.updt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="수정" id="btnUpdate">
                    <input type="button" value="삭제" id="btnDelete">
                    <div style="color: red;">${message}</div>
                </td>
            </tr>
        </table>
	    </form>
</body>
</html>
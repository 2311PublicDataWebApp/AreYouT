<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>동행 매칭하기</title>
	</head>
	<body>
		<form action="/mbti/matching.kh" method="get" enctype="multipart/form-data">
		<h2>회원 목록</h2>
    <table border="1" width="700px">
        <tr>
            <th>닉네임</th>
            <th>나이</th>
            <th>성별</th>
            <th>MBTI</th>
        </tr>
        <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.userId}</td>
            <td><a href="${path}/member/matching.kh?memberId=${member.memberId}">${member.memberNickname}</a></td>
            <td>${member.memberAge}</td>
            <td>${member.memberGender}</td>
             <td>${member.memberMbti}</td>
        </tr>
        </c:forEach>
    </table>
		</form>
	</body>
</html>
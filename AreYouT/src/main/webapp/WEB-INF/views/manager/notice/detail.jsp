<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>공지사항 상세 조회</h1>
		<ul>
			<li>
				<label>제목</label>
				<span>${notice.noticeSubject }</span>
			</li>
			<li>
				<label>작성자</label>
				<span>${notice.noticeWriter }</span>
			</li>
			<li>
				<label>내용</label>
				<span>${notice.noticeContent }</span>
			</li>
			<li>
				<label>첨부파일</label>
				<img src="../resources/nuploadFiles/${notice.noticeFileRename }">
<%-- 				<span><a href="../resources/nuploadFiles/${notice.noticeFileRename }" download>${notice.noticeFilename }</a></span> --%>
			</li>
		</ul>
		<br><br>
		<div>
			<button type="button" onclick="showNoticeList();">목록으로 이동하기</button>
		</div>
		<script type="text/javascript">
			function showNoticeList() {
				location.href = "/manager/notice/list.kh";
			}
		</script>
	</body>
</html>
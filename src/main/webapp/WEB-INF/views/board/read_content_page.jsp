<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 :${key.boardVo.board_title}<br>
글쓴이 :${key.memberVo.member_nick }<br>
조회수 :${key.boardVo.board_readcount }<br>
내용 :${key.boardVo.board_content }<br>
<a href="${pageContext.request.contextPath}/board/main_page.do">목록으로</a>
<c:if test="${!empty sessionUser && sessionUser.member_no == key.memberVo.member_no }">
<a href="${pageContext.request.contextPath}/board/delete_content_process.do?board_no=${key.boardVo.board_no}">삭제</a>
<a href="${pageContext.request.contextPath}/board/update_content_page.do?board_no=${key.boardVo.board_no}">수정</a>
</c:if>
</body>
</html>
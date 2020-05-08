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
<c:choose>
    
    <c:when test="${!empty sessionUser}">
       ${sessionUser.member_nick}님 환영합니다.<br>
       <a href="${pageContext.request.contextPath}/member/logout_process.do">로그아웃</a> 
    </c:when>
       
       <c:otherwise>
               비회원 접근.... <a href="${pageContext.request.contextPath}/member/login_page.do">로그인</a>
       </c:otherwise>
       </c:choose>
       
       <c:if test="${!empty sessionUser}">
       <a href="${pageContext.request.contextPath}/board/write_content_page.do">글쓰기</a>
       </c:if>
   <br>
   <table border="1">
   <tr>
     <td>글번호</td>
      <td>제목</td>
     <td>작성자</td>
     <td>작성일</td>
     <td>조회수</td>
  </tr>
   <c:forEach items="${datalist}" var="boardlist">
   <tr>
      <td>${boardlist.boardVo.board_no}</td>
      <td><a href="${pageContext.request.contextPath}/board/read_content_page.do?board_no=${boardlist.boardVo.board_no}">${boardlist.boardVo.board_title}</a></td>
      <td>${boardlist.memberVo.member_no}</td>
      <td>${boardlist.boardVo.board_writedate}</td>
      <td>${boardlist.boardVo.board_readcount}</td>
     </tr>
     </c:forEach>
   </table>
   <br>   
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
<jsp:include page="../commons/global_nav.jsp"></jsp:include>
	<div class="container mt-5">
	  <div class="row">
	  <div class="col-3"></div>
	  <div class="col">
	     <div class="row text-center"> 
	     <!-- 로고자리 -->
	        <div class="col"><h1>로그인</h1></div>
	     </div>
	     <form action="./login_process.do" method="post">
	      <div class="row mt-5">
	      <!-- id -->
	            <div class=col-1>ID</div>
	            <div class=col>
	            <input type="text" placeholder="이메일을 입력해주세요" name="member_id" class="form-control">
	            </div>
	      </div>
	       <div class="row mt-3">
	        <!-- pw -->
	            <div class=col-1>PW</div>
	            <div class=col>
	            <input type="password" placeholder="비밀번호를 입력해주세요" name="member_pw" class="form-control">
	            </div>
	       </div>
	        <div class="row mt-3"><!-- submit -->
	          <div class ="col"><input type="submit" value="로그인" class="btn btn-primary btn-lg btn-block"></div>
	        </div>
	        </form>
	         <div class="row mt-2">
	          <div class="col"><a href="./join_member_page.do" class="btn btn-outline-primary btn-lg btn-block">회원가입</a></div> 
	         </div>
	  </div>
	  <div class="col-3"></div>
	  </div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>
<form action="./join_member_process.do" method="post">
ID(E메일): <input type="text" name="member_id"><br>
PW: <input type="password" name="member_pw"><br>
닉네임 : <input type="text" name="member_nick"><br>
성별 : <input type="radio" name="member_sex" value="M" checked>남 <input type="radio" name="member_sex" value="W" >여 <br>
취미 : <input type="checkbox" name="member_hobby" value="1">농구
<input type="checkbox" name="member_hobby" value="2">축구
<input type="checkbox" name="member_hobby" value="3">야구
<input type="checkbox" name="member_hobby" value="4">독서 <br> 
<input type="submit" value="회원가입"><br>

</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script type="text/javascript">

function frm_submit(){
 var frm = document.getElementById("frm");
 // 유효성검사
 var idBox = document.getElementById("id"); 
 //id 유효성 검사 
 var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
 
 if(!reg.test(idBox.value)){
	 alert("이메일 형식을 확인해 주세요");
	 idBox.value = "";
	 idBox.focus();
	 return;
 }
 // 비밀번호 유효성 검사 
  reg = /^[A-Za-z0-9]{6,12}$/;
  
  var pwBox = document.getElementById("pw");
  
  if(!reg.test(pwBox.value)){
	  alert("비밀번호는 숫자 6자리~12자리 이하로 입력해주세요")
	  return;
  }
  
 frm.submit();
}

// Ajax 시작 
function testAjax(){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState==4 && xmlhttp.status == 200 ){
		 
		 var box = document.getElementById("test_box");
		 
		 var obj =JSON.parse(xmlhttp.responseText);
		 
		 var ul = document.createElement("ul");
		 //자바스크립트 foreach문
		 for(list of obj){
			var li = document.createElement("li");
			li.innerText = list.member_nick;
			ul.appendChild(li);
		 }
		 box.appendChild(ul);
		}
	}
	xmlhttp.open("get","./testAjax.do");
	
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send();	
}
</script>	
	
	
</head>
<body>
	<jsp:include page="../commons/global_nav.jsp"></jsp:include>
	<div class="container mt-5">
	  <div class="row">
	  <div class="col">
	  </div>
	  <div class="col-10">
	     <div class="row text-center"> 
	     <!-- 로고자리 -->
	        <div class="col"><h1>회원가입</h1></div>
	     </div>
	     <form action="./join_member_process.do" method="post" id="frm">
	      <div class="row mt-5">
	      <!-- id -->
	            <div class=col-1>ID</div>
	            <div class=col>
	            <input type="text" placeholder="이메일을 입력해주세요" name="member_id" class="form-control" id="id">
	            <input type="button" value="아이디확인" onclick="testAjax()">
	            </div>
	      </div>
	       <div class="row mt-3">
	        <!-- pw -->
	            <div class=col-1>PW</div>
	            <div class=col>
	            <input type="password" placeholder="비밀번호를 입력해주세요" name="member_pw" class="form-control" id="pw">
	            </div>
	       </div>
	         <div class="row mt-3">
	        <!-- pw -->
	            <div class=col-1>닉네임</div>
	            <div class=col>
	            <input type="text" placeholder="닉네임을입력해주세요" name="member_nick" class="form-control">
	            </div>
	       </div>
	           <div class="row mt-3">
	        <!-- pw -->
	            <div class=col-1>성별</div>
	            <div class=col>
	           	<div class="custom-control custom-radio">
						<input type="radio" name="member_sex" id="jb-radio-1" class="custom-control-input" value="M" checked>
						<label class="custom-control-label" for="jb-radio-1">남</label>
					</div>
					<div class="custom-control custom-radio">
						<input type="radio" name="member_sex" id="jb-radio-2" class="custom-control-input"  value="W">
						<label class="custom-control-label" for="jb-radio-2">여</label>
					</div>
	            </div>
	       </div>
	       <div class="row mt-3">
	            <div class=col-1>취미</div>
	            <div class=col>
	              	<label class="checkbox-inline">
	                <input type="checkbox" id="inlineCheckbox1" name="member_hobby" value="1">농구
	                 </label>
	                <label class="checkbox-inline ml-3">
	               <input type="checkbox" id="inlineCheckbox2" name="member_hobby" value="2">축구
	               </label>
	               <label class="checkbox-inline ml-3">
	               <input type="checkbox" id="inlineCheckbox3" name="member_hobby" value="3">야구
	              </label>
	               <label class="checkbox-inline ml-3">
	               <input type="checkbox" id="inlineCheckbox4" name="member_hobby" value="4">독서
	              </label>
	            </div>
	       </div> 
	        <div class="row mt-3"><!-- submit -->
	          <div class ="col"><input onclick="frm_submit()" type="button" value="회원가입" class="btn btn-primary btn-lg btn-block"></div>
	        </div>
	        </form>
	  </div>
	  <div class="col"></div>
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

<div id="test_box">



</div>
</body>
</html>
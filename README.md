# Spring_final_ex
05/18
<br>
타이머 -> Ajax로 처리하자
<br>
-----아이디 중복 확인
<br>
join_member_page.jsp - fuction confirmId - Ajax 기본 구조
<br>
MemberController - confirmId - 로그 찍어보고
<br>
MemberSQLMapper - selectById
<br>
MemberServiceImpl - confirmId
<br>
MemberController - confirmId - 서비스 메소드 실행, @ResponseBody
<br>
join_member_page.jsp - funtion 로직 추가, isConfirmId 유효성검사(반드시 중복확인 해야하게끔)
<br>
join_member_page.jsp - confirmId_jQuery() - 슬림버전 지워줘야함
<br>
비동기식 : 스레드 느낌
<br>
-----댓글
<br>
read_content_page.do - UI 잡고
<br>
테이블 생성 CREATE TABLE FB_Reply( reply_no NUMBER(8) PRIMARY KEY, board_no NUMBER(8), member_no NUMBER(8), reply_content VARCHAR2(1000), reply_writedate DATE );
<br>
ReplyVo
<br>
ReplySQLMapper
<br>
ReplySQLMapper.xml
<br>
BoardServiceImpl - getRepleList, writeReply 추가
<br>
RESTfulBoardController - writeReplyProcess
<br>
read_content_page.jsp - onclick, writeReply()
<br>
RESTfulBoardController - getReplyList()
<br>
pom.xml - JSON 변환 라이브러리 추가
<br>
read_content_page.jsp - refreshReplyList(), 밑에 id 지정(
<br>
read_content_page.jsp - body에 onload 추가
<br>

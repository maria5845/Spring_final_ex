# Spring_final_ex version7

-----이메일 인증 <br>
 <br>
FB_Member_Auth 테이블 생성 <br>
DROP TABLE FB_Member_Auth; <br>

CREATE TABLE FB_Member_Auth( auth_no NUMBER(8) PRIMARY KEY, member_no NUMBER(8), auth_certification VARCHAR2(4), auth_key VARCHAR2(100) ); <br>

DROP SEQUENCE FB_Member_Auth_seq; <br>

CREATE SEQUENCE FB_Member_Auth_seq; <br>

AuthVo <br>

AuthSQLMapper <br>

AuthSQLMapper.xml <br>

MemberController - joinMemberProcess 수정 <br>

MemberServiceImpl - joinMember 수정 <br>

MemberSQLMapper - selectByIdAndPw 수정 <br>

pom.xml 외부 라이브러리 2개 등록 <br>

servlet-context.xml 빈 추가 <br>

MemberController - 스레드 추가, certificationProcess 추가 <br>

MemberServiceImpl - certification 추가 <br>

-----AJAX

join_member_page.jsp - AJAX 코드 추가** <br>

testAjax.jsp** <br>

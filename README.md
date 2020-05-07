# Spring_final_ex
05/06

스프링 final ver1

<-------------------------pom.xml-------------------------->

pom.xml 위 쪽에 자바버전 수정(1.8버전), 스프링프레임웍버전 수정(5.0.7)

pom.xml 맨 아래쪽 configuration 자바버전으로 수정(1.8) -> 프로젝트 우클릭 - 메이븐 - 업데이트 프로젝트

pom.xml dependencies 밑에 외부 라이브러리 추가(mybatis 등, 덮어쓰는 거 아니고 추가~~) 위에

src - main - WEB-INF에 lib폴더 생성 => ojdbc6_g.jar 추가

<-------------------------web.xml-------------------------->
5. servlet-mapping 밑에 utf-8 필터 등록

<---------------------root-context.xml----------------->
6. Namespaces - mybatis-spring, aop, context 체크!(task 나중에 필요할 수도 있다)

mybatis 관련 빈 등록!

맨 밑에 base-package만 수정

------------
9. 서버 한 번 실행해보자! 

<------com.ja.freeboard.member.controller------->
10. MemberController

<-------------views---------->
11. login_page.jsp

join_member_page.jsp
<----------com.ja.freeboard.vo-------->
13. MemberVo

<----------com.ja.freeboard.mapper--------->
14. MemberSQLMapper

<---------com.ja.freeboard.member.service------->
15.MemberServiceImpl

-------------
*servlet-context : 컨트롤러 root-context : 서비스, 매퍼

**기본 생성자 안 만들면 400 오류 뜰 수 있음!

<--------com.ja.freeboard.mapper---------->
16. HobbySQLMapper

<--------com.ja.freeboard.vo------------->
17. HobbyVo

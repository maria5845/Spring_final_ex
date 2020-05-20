# Spring_final_ex version1
05/06

스프링 final ver1 <br>

<-------------------------pom.xml-------------------------->

pom.xml 위 쪽에 자바버전 수정(1.8버전), 스프링프레임웍버전 수정(5.0.7) <br>

pom.xml 맨 아래쪽 configuration 자바버전으로 수정(1.8) -> 프로젝트 우클릭 - 메이븐 - 업데이트 프로젝트<br>

pom.xml dependencies 밑에 외부 라이브러리 추가(mybatis 등, 덮어쓰는 거 아니고 추가) <br>

src - main - WEB-INF에 lib폴더 생성 => ojdbc6_g.jar 추가 <br>

<-------------------------web.xml--------------------------> <br>
5. servlet-mapping 밑에 utf-8 필터 등록 <br>

<---------------------root-context.xml-----------------><br>
6. Namespaces - mybatis-spring, aop, context 체크!(task 나중에 필요할 수도 있다) <br>

mybatis 관련 빈 등록! <br>

맨 밑에 base-package만 수정 <br>

------------
9. 서버 한 번 실행해보자!  <br>

<------com.ja.freeboard.member.controller-------> <br>
10. MemberController <br>

<-------------views----------> <br>
11. login_page.jsp <br>

join_member_page.jsp <br>

<----------com.ja.freeboard.vo--------> <br>
12. MemberVo <br>

<----------com.ja.freeboard.mapper---------> <br>
13. MemberSQLMapper <br>

<---------com.ja.freeboard.member.service-------> <br>
14.MemberServiceImpl <br>

-------------
*servlet-context : 컨트롤러 root-context : 서비스, 매퍼 <br>

**기본 생성자 안 만들면 400 오류 뜰 수 있음! <br>

<--------com.ja.freeboard.mapper----------> <br>
15. HobbySQLMapper <br>

<--------com.ja.freeboard.vo-------------> <br>
16. HobbyVo

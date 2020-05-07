package com.ja.freeboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.ja.freeboard.vo.HobbyVo;

public interface HobbySQLMapper {
	@Insert("INSERT INTO FB_Hobby VALUES(FB_Hobby_seq.NEXTVAL,#{member_no},#{hobby_category_no})")
    // 매개변수값이 2개 이상일때는 mybatis용 @Param으로 설정을 지정하고 분류할  수 있다 .
	public void insert(
			@Param("member_no") int member_no, 
			@Param("hobby_category_no") int hobby_category_no);
}

package com.ja.freeboard.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.HobbySQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.vo.MemberVo;

@Service
public class MemberServiceImpl {

	// Service 티어에서는 Mapper 티어의 SQL문을 주입받는 역할을 한다.
	@Autowired
	private MemberSQLMapper memberSQLMapper;

	@Autowired
	private HobbySQLMapper hobbySQLMapper;

	public void joinMember(MemberVo memberVo, int[] member_hobby) {

		// 맴버 넘버값을 fb_hobby 테이블에 담기 위한 작업 
		// 1.맴버 넘버 값을 따로 빼서 담는 creatKey 메소드를 생성하여 담는다
		// 2. 
		int member_key = memberSQLMapper.creatKey();
		
		memberVo.setMember_no(member_key);
		
		memberSQLMapper.insert(memberVo);
		
	    try {
	    for(int hobby : member_hobby) {
	    	hobbySQLMapper.insert(member_key, hobby);
	    }
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}

}

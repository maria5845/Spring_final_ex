package com.ja.freeboard.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.AuthSQLMapper;
import com.ja.freeboard.mapper.HobbySQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.util.FBMessageDigest;
import com.ja.freeboard.vo.AuthVo;
import com.ja.freeboard.vo.MemberVo;

import java.security.*;

@Service
public class MemberServiceImpl {

	// Service 티어에서는 Mapper 티어의 SQL문을 주입받는 역할을 한다.
	@Autowired
	private MemberSQLMapper memberSQLMapper;

	@Autowired
	private HobbySQLMapper hobbySQLMapper;

	@Autowired
	private AuthSQLMapper authSQLMapper;

	public void joinMember(MemberVo memberVo, int[] member_hobby, AuthVo authVo) {

		// 비밀번호 해싱작업 유틸 클래스로 메서드를 분리하였다.
		String hashCode = FBMessageDigest.digest(memberVo.getMember_pw());

		memberVo.setMember_pw(hashCode);

		// 맴버 넘버값을 fb_hobby 테이블에 담기 위한 작업
		// 1.맴버 넘버 값을 따로 빼서 담는 creatKey 메소드를 생성하여 담는다

		int member_key = memberSQLMapper.creatKey();

		memberVo.setMember_no(member_key);

		memberSQLMapper.insert(memberVo);

		authVo.setMember_no(member_key);

		authSQLMapper.insert(authVo);

		// 체크박스 체크가 없을시 예외처리 진행
		if (member_hobby == null) {
			return;
		}
		for (int hobby : member_hobby) {
			hobbySQLMapper.insert(member_key, hobby);
		}
	}

	public MemberVo login(MemberVo memberVo) {
		String hashCode = FBMessageDigest.digest(memberVo.getMember_pw());
		memberVo.setMember_pw(hashCode);
		return memberSQLMapper.SelectByIdAndPw(memberVo);
	}

	public void certification(String key) {
		authSQLMapper.update(key);
	}

	public boolean confrimId(String id) {

		if (memberSQLMapper.SelectById(id) == null) {
			return true; // 사용가능
		} else {
			return false; // 사용 불가능 
		}

	}
}
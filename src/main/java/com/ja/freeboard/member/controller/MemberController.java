package com.ja.freeboard.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.freeboard.member.service.MemberServiceImpl;
import com.ja.freeboard.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	//controller티어에서 Autowired를 통해 service 티어의 내용을 주입받는 역할을 한다.
	@Autowired
	private MemberServiceImpl memberService;

	@RequestMapping("/login_page.do")

	public String loginPage() {

		return "member/login_page";

	}

	@RequestMapping("/join_member_page.do")
	public String joinMemberPage() {

		return "member/join_member_page";

	}

	@RequestMapping("/join_member_process.do")
	public String joinMemberProcess(MemberVo memberVo, int[] member_hobby) {
		memberService.joinMember(memberVo,member_hobby);
		return "redirect:./login_page.do";
	}
}

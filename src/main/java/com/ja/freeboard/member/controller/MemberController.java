package com.ja.freeboard.member.controller;

import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.freeboard.member.service.MemberServiceImpl;
import com.ja.freeboard.vo.AuthVo;
import com.ja.freeboard.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	// controller티어에서 Autowired를 통해 service 티어의 내용을 주입받는 역할을 한다.
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/login_page.do")
	public String loginPage() {
		System.out.println("자바스크립트 서버 응답함");
		return "member/login_page";
	}

	@RequestMapping("/join_member_page.do")
	public String joinMemberPage() {
		return "member/join_member_page";
	}

	@RequestMapping("/certification_process.do")
	public String certificationProcess(String key) {
		memberService.certification(key);
		return "member/certification_complete";

	}

	@RequestMapping("/join_member_process.do")
	public String joinMemberProcess(MemberVo memberVo, int[] member_hobby) {

		// 인증키 생성
		AuthVo authVo = new AuthVo();
		String authkey = UUID.randomUUID().toString();
		authVo.setAuth_key(authkey);

		memberService.joinMember(memberVo, member_hobby, authVo);

		// 메일 발송, 쓰레드 처리를 진행(아래 쓰레드 클래스 작성함)

		FBMailSenderThread thread = new FBMailSenderThread(mailSender, memberVo.getMember_id(), authVo.getAuth_key());
		thread.start();

		return "redirect:./login_page.do";
	}

	@RequestMapping("/login_process.do")
	public String loginProcess(MemberVo memberVo, HttpSession session) {
		MemberVo userData = memberService.login(memberVo);

		if (userData == null) {
			// 로그인 실패
			return "/member/login_fail";
		} else {
			// 로그인 성공 httpSesssion API를 불러오고 set으로 담아주자 리다이렉트 이후 사용을 위해
			session.setAttribute("sessionUser", userData);
			System.out.println("메인페이지 접속 ");
			return "redirect:/board/main_page.do";
		}

	}

	@RequestMapping("/logout_process.do")
	public String logOutProcess(HttpSession session) {
		session.invalidate();
		return "redirect:/board/main_page.do";
	}
    
	@RequestMapping("/confirmId.do")
	@ResponseBody
	public String confirmid(String id) {
		if (memberService.confrimId(id)) {
			return "true";
		} else {
			return "false";
		}
	}

}

class FBMailSenderThread extends Thread {

	private String to;
	private String authKey;
	private JavaMailSender mailSender;

	// 메일 전송의 데드락을 피하기위해 쓰레드 처리
// 쓰레드는 런을 반드시 오버라이드
	public FBMailSenderThread(JavaMailSender mailSender, String to, String authKey) {
		this.mailSender = mailSender;
		this.to = to;
		this.authKey = authKey;
	}

	@Override
	public void run() {
		try {

			MimeMessage message = null;
			MimeMessageHelper messageHelper = null;
			message = mailSender.createMimeMessage();
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject("[인증메일발송] 회원가입을 축하드립니다. ");
			String link = "http://localhost:8181/freeboard/member/certification_process.do?key=" + authKey;
			String text = "";
			text += "FB회원가입을 축하합니다. <br> ";
			text += "회원가입 완료를 위해 아래 링크를 클릭해 주세요<br> ";
			text += "<a href='" + link + "'>";
			text += "링크를 클릭해주세요";
			text += "</a>";
			messageHelper.setText(text, true);
			messageHelper.setFrom("1111", "이찬용");
			messageHelper.setTo(to);
			// messageHelper.addInline(contentId, dataSource);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

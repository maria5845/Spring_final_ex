package com.ja.freeboard.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.freeboard.board.service.BoardServiceImpl;
import com.ja.freeboard.vo.MemberVo;
import com.ja.freeboard.vo.ReplyVo;

@Controller
@ResponseBody
@RequestMapping("/board/*")
public class RESTfulBoardController {
	@Autowired
   private BoardServiceImpl boardService;
	
	@RequestMapping("/write_reply_process.do")
	public String writeReplyProcess(ReplyVo replyVo,HttpSession session) {
		
		int memberNo= ((MemberVo)session.getAttribute("sessionUser")).getMember_no();
	    
		replyVo.setMember_no(memberNo);
		
	    boardService.writeReply(replyVo);
	
		return "true";
	}
	@RequestMapping("/get_reply_list.do")
	public List<Map<String,Object>> getReplyList(int board_no) {
		
		
		List<Map<String,Object>> list = boardService.getReplyList(board_no);
		
		return list;
		
	} 
}

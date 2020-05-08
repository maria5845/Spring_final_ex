package com.ja.freeboard.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.BoardSQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.vo.BoardVo;
import com.ja.freeboard.vo.MemberVo;

@Service

public class BoardServiceImpl {
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	@Autowired
	private MemberSQLMapper memberSQLMapper;

	public void writeContent(BoardVo boardVo) {
		boardSQLMapper.insert(boardVo);

	}

	public List<Map<String, Object>> getBoardList() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		List<BoardVo> boardlist = boardSQLMapper.selectAll();

		for (BoardVo boardVo : boardlist) {

			MemberVo memberVo = memberSQLMapper.SelectByNo(boardVo.getMember_no());

			Map<String, Object> map = new HashMap<String, Object>();
			// Map<String,Object> map = new HashMap<>(); 이것도 가능 1.8버전 문법
			map.put("memberVo", memberVo);
			map.put("boardVo", boardVo);

			list.add(map);
		}
		return list;
	}

	public Map<String, Object> getBoard(int board_no) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		boardSQLMapper.updateReadCount(board_no);
		
		BoardVo boardVo = boardSQLMapper.selectByNo(board_no);
		
		MemberVo memberVo = memberSQLMapper.SelectByNo(boardVo.getMember_no());
		
		map.put("memberVo", memberVo);
		
		map.put("boardVo", boardVo);
		
		return map;

	}

	public void deleteContent(int board_no) {
		boardSQLMapper.deleteByNo(board_no);
	}

	public void updateContent(BoardVo boardVo) {
		boardSQLMapper.update(boardVo);
	}
}

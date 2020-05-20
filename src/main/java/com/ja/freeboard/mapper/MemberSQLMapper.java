package com.ja.freeboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.freeboard.vo.MemberVo;

public interface MemberSQLMapper {
    
	public int creatKey();

	public void insert(MemberVo memberVo);
    
	public MemberVo SelectByIdAndPw(MemberVo memberVo);
   
    public MemberVo SelectByNo(int no);
    
    public MemberVo SelectById(String id);
    
}

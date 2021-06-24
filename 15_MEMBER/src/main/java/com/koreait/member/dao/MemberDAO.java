package com.koreait.member.dao;

import com.koreait.member.dto.Member;

public interface MemberDAO {

	public Member loginMember(String id, String pw);
	public int idCheck(String id);
	
}

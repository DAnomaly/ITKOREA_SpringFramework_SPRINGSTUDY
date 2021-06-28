package com.koreait.member.dao;

import com.koreait.member.dto.Member;

public interface MemberDAO {

	public Member loginMember(Member member);
	public int idCheck(String id);
	public int joinMember(Member member);
	public void leave(long no);
	public int editMember(Member member);
	public String findId(String email);
	public int findPw(String id, String email);
	public int changePw(String pw, String id);
}

package com.koreait.mygallery.dao;

import com.koreait.mygallery.dto.Member;

public interface MemberDAO {

	public Member loginMember(Member member);
	public int joinMember(Member member);
	public int checkId(Member member);
	public int checkEmail(Member member);
}

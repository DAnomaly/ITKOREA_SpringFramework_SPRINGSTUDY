package com.koreait.mygallery.dao;

import com.koreait.mygallery.dto.Member;

public interface MemberDAO {

	public Member loginMember(Member member);
	public int joinMember(Member member);
	public int checkId(Member member);
	public int checkEmail(Member member);
	public int editMember(Member member);
	public int removeMember(Member member);
	public int countGalleryByNo(Member member);
	public int countBoardByNo(Member member);
	public Member findMember(Member member);
}

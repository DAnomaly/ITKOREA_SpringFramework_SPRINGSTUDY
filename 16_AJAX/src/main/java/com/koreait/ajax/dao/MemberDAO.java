package com.koreait.ajax.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import com.koreait.ajax.dto.Member;

public interface MemberDAO {
	public int getTotalMemberCount();
	public List<Member> selectMemberList(int beginRecord, int endRecord);
	public int insertMember(Member member) throws DuplicateKeyException;
}

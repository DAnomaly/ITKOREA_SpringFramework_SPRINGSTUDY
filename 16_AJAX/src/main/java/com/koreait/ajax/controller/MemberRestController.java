package com.koreait.ajax.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ajax.command.DeleteMemberCommand;
import com.koreait.ajax.command.InsertMemeberCommand;
import com.koreait.ajax.command.SelectListMemberCommand;
import com.koreait.ajax.command.UpdateMemberCommand;
import com.koreait.ajax.dto.Member;

/*
 * 회원 관리 RESTful 처리
 * 
 * 1. RESTful : URI + HTTP Method
 * 2. CRUD
 *              URI            HTTP Method   기존 URI
 *    1) 목록   member         GET           selectMemberList.do
 *    2) 보기   (member/{no})  (GET)         (selectMemberByNo.do?no=1)
 *    3) 삽입   member         POST          insertMember.do
 *    4) 수정   member         PUT           updateMember.do
 *    5) 삭제   member/{no}    DELETE        deleteMember.do?no=1
 */


/*
 * @RestController
 * 
 * 1. 모든 메소드의 반환 값을 @ResponseBody 처리한다.
 * 2. 모든 메소드는 @ResponseBody 애너테이션을 추가하지 않아도 ajax 처리가 된다.
 */

@RestController
public class MemberRestController {
	
	// field
	private SqlSession sqlSession;
	private InsertMemeberCommand insertMemeberCommand;
	private SelectListMemberCommand selectListMemberCommand;
	private UpdateMemberCommand updateMemberCommand;
	private DeleteMemberCommand deleteMemberCommand;
	
	// constructor
	@Autowired
	public MemberRestController(SqlSession sqlSession, InsertMemeberCommand insertMemeberCommand,
			SelectListMemberCommand selectListMemberCommand, UpdateMemberCommand updateMemberCommand,
			DeleteMemberCommand deleteMemberCommand) {
		super();
		this.sqlSession = sqlSession;
		this.insertMemeberCommand = insertMemeberCommand;
		this.selectListMemberCommand = selectListMemberCommand;
		this.updateMemberCommand = updateMemberCommand;
		this.deleteMemberCommand = deleteMemberCommand;
	}

	@GetMapping(value="member", produces="application/json; charset=UTF-8")
	public Map<String, Object> selectListMemberCommand(
			int page,
			Model model) {
		model.addAttribute("page", page);
		return selectListMemberCommand.execute(sqlSession, model);
	}
	
	/*
	@GetMapping(value="member/{no}", produces="application/json; charset=UTF-8")
	public Map<String, Object> selectMemberByNo(
			@PathVariable("no") long no,
			Model model){
		return selectOneMemberCommand.execute(sqlSession, model);
	}
	*/
	
	@PostMapping(value="member", produces="application/json; charset=UTF-8")
	public Map<String, Object> insertMember(
			@RequestBody Member member,
			HttpServletResponse response,
			Model model) {
		model.addAttribute("member", member);
		model.addAttribute("response", response);
		return insertMemeberCommand.execute(sqlSession, model);
	}
	
	@PutMapping(value="member", produces="application/json; charset=UTF-8")
	public Map<String, Object> updateMember(
			@RequestBody Member member,
			Model model) {
		model.addAttribute("member", member);
		return updateMemberCommand.execute(sqlSession, model);
	}
	
	@DeleteMapping(value="member/{no}", produces="application/json; charset=UTF-8")
	public Map<String, Object> deleteMember(
			@PathVariable("no") long no,
			Model model) {
		Member member = new Member();
		member.setNo(no);
		model.addAttribute("member", member);
		return deleteMemberCommand.execute(sqlSession, model);
	}
}

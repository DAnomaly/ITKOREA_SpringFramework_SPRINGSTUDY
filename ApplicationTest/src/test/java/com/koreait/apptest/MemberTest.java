package com.koreait.apptest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.apptest.config.BeanConfiguration;
import com.koreait.apptest.dao.MemberDAO;
import com.koreait.apptest.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={BeanConfiguration.class})
public class MemberTest {

	// junit 테스트는 스프링을 모두 돌리지 않는다.
	// @Autowired 동작 안 한다.
	// Oracle JDBC도 tomcat에 넣어 두면 동작하지 않는다.
	// 현재 프로젝트에 포함되어 있어야 한다. (pom.xml 참고)
	
	// junit 테스트 시 스프링 모든 기능 활용을 위해서
	// spring-test 디펜던시를 추가한다. (스프링 프레임워크와 같은 버전)
	// spring-test 디펜던시 지원 애너테이션
	// @RunWith : 이 테스트는 스프링을 함께 돌려달다.
	// @ContextConfiguration : Bean을 여기서 찾아라.
	
	// field
	@Autowired
	private SqlSession sqlSession;
	
	// 가입 점검
	@Test
	public void joinTest() {
		assertNotNull("SqlSession을 불러오지 못함", sqlSession);
		
		Member member = new Member();
		member.setId("test");
		member.setPw("1123");
		member.setName("테스트");
		member.setEmail("test@alert.cor");
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int result = memberDAO.join(member);
		
		assertNotEquals("테스트 계정 추가에 실패함!", 0, result);
	}

	// 아이디 중복 점검 테스트
	// admin 아이디를 가진 아이디가 있으면 검사 통과
	// admin 아이디를 가진 아이디가 없으면 검사 실패
	@Test
	public void 아이디중복체크테스트() {
		assertNotNull("SqlSession을 불러오지 못함", sqlSession);
		
		String id = "admin";
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int result = memberDAO.idCheck(id);
		
		assertTrue("찾으시는 아이디가 존재하지 않습니다." , result > 0);
	}
	
}

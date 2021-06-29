package com.koreait.search.dao;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.koreait.search.config.BeanConfiguration;

public class TestEmployeesDAO {

	private SqlSession sqlSession;
	private EmployeesDAO dao;
	
	@Before
	public void setUp() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		sqlSession = (SqlSession)context.getBean("sqlSession");
		dao = sqlSession.getMapper(EmployeesDAO.class);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

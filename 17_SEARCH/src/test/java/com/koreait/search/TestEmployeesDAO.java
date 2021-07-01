package com.koreait.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.koreait.search.config.BeanConfiguration;
import com.koreait.search.dao.EmployeesDAO;
import com.koreait.search.dto.Employees;

public class TestEmployeesDAO {

	private Logger logger;
	private SqlSession sqlSession;
	private EmployeesDAO dao;
	AbstractApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		logger = LoggerFactory.getLogger(TestEmployeesDAO.class);
		sqlSession = (SqlSession)context.getBean("sqlSession");
	}

	@Test
	public void test() {
		/*
		assertNotNull(sqlSession);
		dao = sqlSession.getMapper(EmployeesDAO.class);
		assertNotNull(dao);
		List<Employees> list = dao.selectListEmployees(1, 10);
		assertEquals(10, list.size());
		for (Employees employee : list) {
			logger.info(employee.toString());
		}
		*/
	}
	
	@After
	public void end() throws Exception {
		context.close();
	}

}

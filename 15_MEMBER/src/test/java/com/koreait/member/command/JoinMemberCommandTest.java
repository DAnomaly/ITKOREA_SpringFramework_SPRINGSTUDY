package com.koreait.member.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinMemberCommandTest {
	
	private String pw;
	private static Logger logger = LoggerFactory.getLogger(JoinMemberCommandTest.class);
	
	@Before
	public void setUp() throws Exception {
		pw = "1234";
	}

	@Test
	public void test() {
		String pw1 = SecurityUtils.sha256(pw);
		assertNotNull(pw1);
		logger.info(pw1);
		String pw2 = SecurityUtils.encodeBase64(pw);
		assertNotNull(pw2);
		logger.info(pw2);
		assertEquals(pw1, pw2);
	}

}

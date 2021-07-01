package com.koreait.integration.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.integration.domain.Board;

/*
 * @Repository 
 *   1. @Component와 같은 기능을 지원한다.
 *   2. 가시성을 위해 @Repository, @Service 애노테이션을 사용한다.
 *   3. 외부I/O 처리 : @Repository (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
 */
@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Board> selectAll() {
		return sqlSession.selectList("com.koreait.integration.repository.board.selectAll");
	}
	
	public List<Board> selectQuery(Map<String, Object> params) {
		return sqlSession.selectList("com.koreait.integration.repository.board.selectQuery", params);
	}
	
}

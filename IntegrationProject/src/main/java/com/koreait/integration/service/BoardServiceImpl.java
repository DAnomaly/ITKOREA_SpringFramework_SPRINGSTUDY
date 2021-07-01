package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.integration.domain.Board;
import com.koreait.integration.repository.BoardRepository;

/*
 * @Service
 *   1. @Component와 같은 기능을 지원한다.
 *   2. 가시성을 위해 @Repository, @Service 애노테이션을 사용한다.
 *   3. 로직 처리 : @Service (서비스 레이어, 내부에서 자바 로직을 처리함)
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;
	
	@Override
	public List<Board> totalList() {
		return repository.selectAll();
	}

	@Override
	public List<Board> searchList(Map<String, Object> params) {
		return repository.selectQuery(params);
	}

}

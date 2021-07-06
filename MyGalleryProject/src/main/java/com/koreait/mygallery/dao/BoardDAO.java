package com.koreait.mygallery.dao;

import java.util.List;
import java.util.Map;

import com.koreait.mygallery.dto.Board;

public interface BoardDAO {

	public int countBoard(Map<String, Object> map);
	public List<Board> selectListBoard(Map<String, Object> map);
	public int insertNewBoard(Board board);
	public int insertCommentBoard(Board board);
	public int deleteBoard(Board board);
}

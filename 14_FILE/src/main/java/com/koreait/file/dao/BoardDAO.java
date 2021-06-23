package com.koreait.file.dao;

import java.util.List;

import com.koreait.file.dto.Board;

public interface BoardDAO {

	public List<Board> selectListBoard();
	public Board selectOneBoard(long no);
	public int insertBoard(String writer, String title, String content, String filename);
	public int updateBoard();
	public int deleteBoard();
	
}

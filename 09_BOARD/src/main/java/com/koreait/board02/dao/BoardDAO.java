package com.koreait.board02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.koreait.board02.dto.Board;

@Component
public class BoardDAO {

	@Autowired
	private JdbcTemplate template;
	private String sql;

	public List<Board> selectListBoard() {
		sql = "SELECT NO, WRITER, TITLE, CONTENT, POSTDATE FROM BOARD";
		return template.query(sql, new BeanPropertyRowMapper<>(Board.class));
	}

	public Board selectOneBoard(long no) {
		sql = "SELECT NO, WRITER, TITLE, CONTENT, POSTDATE FROM BOARD WHERE NO = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<>(Board.class), no);
	}

	public int updateBoard(Board board) {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE NO = ?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setLong(3, board.getNo());
			}
		});
	}

	public int deleteBoard(long no) {
		sql = "DELETE FROM BOARD WHERE NO = ?";
		return template.update(sql, no);
	}

	public int insertBoard(Board board) {
		return template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, board.getWriter());
				ps.setString(2, board.getTitle());
				ps.setString(3, board.getContent());
				return ps;
			}
		});
	}
}

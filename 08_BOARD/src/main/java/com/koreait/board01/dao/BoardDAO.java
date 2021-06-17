package com.koreait.board01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.board01.command.InsertBoardCommand;
import com.koreait.board01.command.ListBoardCommand;
import com.koreait.board01.command.SelectBoardCommand;
import com.koreait.board01.command.UpdateBoardCommand;
import com.koreait.board01.dto.Board;

/**
 * DB 연결 및 SQL실행<br>
 * 
 * TABLE : BOARD
 * 
 * @author DAnomaly
 *
 */
public class BoardDAO {

	// field
	private DataSource dataSource;
	private static BoardDAO instance;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// constructor
	private BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// mehtod
	/**
	 * SingleTon Pattern
	 * 
	 * @return BoardDAO 싱글톤 클래스
	 */
	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
	/**
	 * Connection, PreparedStatement, ResultSet을 닫아주는 메소드
	 * 
	 * @param con
	 * @param ps
	 * @param rs
	 */
	private void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB의 board 테이블의 개수 확인
	 * 
	 * @see ListBoardCommand#execute(org.springframework.ui.Model)
	 * @return board 데이터의 수
	 */
	public int boardCount() {
		int count = 0;
		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(NO) FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return count;
	}
	
	/**
	 * DB의 Board 태이블의 모든 데이터를 가져와 List에 담고 반환
	 * 
	 * @see ListBoardCommand#execute(org.springframework.ui.Model)
	 * @param map startRecord, endRecord가 존재하는 map
	 * @return list
	 */
	public List<Board> selectBoardList(Map<String, Object> map) {
		List<Board> list = new ArrayList<Board>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT B.NO, B.WRITER, B.TITLE, B.CONTENT, B.POSTDATE "
				+ "  FROM ("
				+ "       SELECT ROWNUM AS RN, A.NO, A.WRITER, A.TITLE, A.CONTENT, A.POSTDATE "
				+ "         FROM ("
				+ "              SELECT NO, WRITER, TITLE, CONTENT, POSTDATE FROM BOARD ORDER BY NO DESC) A) B"
				+ " WHERE RN BETWEEN ? AND ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int)map.get("startRecord"));
			ps.setInt(2, (int)map.get("endRecord"));
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setNo(rs.getLong(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setPostdate(rs.getTimestamp(5));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 새글 작성 메소드
	 * 
	 * @see InsertBoardCommand#execute(org.springframework.ui.Model)
	 * @param board
	 * @return 결과값 ( 변화한 row의 값 )
	 */
	public int insertBoard(Board board) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		
		return result;
	}
	
	/**
	 * NO를 통해 DB에서 개시글을 받아옵니다.
	 * 
	 * @see SelectBoardCommand#execute(org.springframework.ui.Model)
	 * @param no
	 * @return Board 데이터
	 */
	public Board selectOneBoard(long no) {
		Board board = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, POSTDATE FROM BOARD WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setNo(rs.getLong(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setPostdate(rs.getTimestamp(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return board;
	}
	
	/**
	 * DB : 개시글 수정
	 * @see UpdateBoardCommand#execute(org.springframework.ui.Model)
	 * @param board
	 */
	public void updateBoard(Board board) {
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setLong(3, board.getNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
	/**
	 * DB : 개시글 삭제
	 * 
	 * @param no 개시글 번호
	 */
	public void deleteBoard(long no) {
		try {
			
			con = dataSource.getConnection();
			sql = "DELETE FROM BOARD WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,ps,null);
		}
	}
}

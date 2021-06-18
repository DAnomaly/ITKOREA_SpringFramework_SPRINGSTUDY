package com.koreait.contact01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.koreait.contact01.dto.Contact;

@Component
public class ContactDAO {
	
	// field
	private final static Logger LOGGER = LoggerFactory.getLogger(ContactDAO.class);
	private DataSource dataSource;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	// constructor
	/**
	 * <strong>생성자</strong><br>
	 * dataSource 생성
	 */
	public ContactDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// method
	/**
	 * Connection, PreparedStatement, ResultSet을 닫아주는 메소드<br>
	 * close() 호출
	 * 
	 * @param con
	 * @param ps
	 * @param rs
	 */
	private void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null)
				con.close();
			if(ps != null)
				ps.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB : CONTACT의 모든 정보를 가져온다.
	 * 
	 * @return DB : CONTACT의 모든 정보
	 */
	public List<Contact> selectListContact() {
		List<Contact> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Contact vo = new Contact();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setAddr(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setNote(rs.getString(6));
				list.add(vo);
			}
		} catch (SQLException e) {
			LOGGER.warn("selectListContact() 메소드 : 오류발생");
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * DB : 선택한 CONTACT의 정보를 가져온다.
	 * 
	 * @param no 선택한 연락처
	 * @return DB : 선택한 CONTACT의 정보
	 */
	public Contact selectOneContact(long no){
		Contact contact = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				contact = new Contact();
				contact.setNo(rs.getLong(1));
				contact.setName(rs.getString(2));
				contact.setTel(rs.getString(3));
				contact.setAddr(rs.getString(4));
				contact.setEmail(rs.getString(5));
				contact.setNote(rs.getString(6));
			}
		} catch (SQLException e) {
			LOGGER.warn("selectOneContact() 메소드 : 오류발생");
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return contact;
	}
	
	/**
	 * DB : CONTACT에 연락처 추가
	 * 
	 * @param vo Contact 정보
	 * @return 등록 결과 : 오류 발생시 0 반환
	 */
	public int insertContact(Contact vo) {
		int result = 0;
		LOGGER.info("insertContact() 메소드 :" + vo.toString());
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getAddr());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getNote());
			result = ps.executeUpdate();
			LOGGER.info("insertContact() 메소드 : 연락처 등록완료");
		} catch (Exception e) {
			LOGGER.warn("insertContact() 메소드 : 오류발생");
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/**
	 * DB : CONTACT의 연락처 수정
	 * 
	 * @param vo Contact 정보
	 * @return 등록 결과 : 오류 발생시 0 반환
	 */
	public int updateContact(Contact vo) {
		int result = 0;
		LOGGER.info("updateContact() 메소드 :" + vo.toString());
		try {
			con = dataSource.getConnection();
			sql = "UPDATE CONTACT SET NAME = ?, TEL = ?, ADDR = ?, EMAIL = ?, NOTE = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getAddr());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getNote());
			ps.setLong(6, vo.getNo());
			result = ps.executeUpdate();
			LOGGER.info("updateContact() 메소드 : 연락처 수정완료");
		} catch (Exception e) {
			LOGGER.warn("updateContact() 메소드 : 오류발생");
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/**
	 * DB : CONTACT의 연락처 삭제
	 * 
	 * @param no 삭제할 Contact의 NO
	 * @return 등록 결과 : 오류 발생시 0 반환
	 */
	public int deleteContact(long no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM CONTACT WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
			LOGGER.info("deleteContact() 메소드 : 연락처 삭제완료");
		} catch (Exception e) {
			LOGGER.warn("deleteContact() 메소드 : 오류발생");
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return result;
	}
}

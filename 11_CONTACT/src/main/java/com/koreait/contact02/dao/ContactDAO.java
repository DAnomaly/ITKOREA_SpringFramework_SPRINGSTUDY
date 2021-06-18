package com.koreait.contact02.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.koreait.contact02.dto.Contact;

@Component
public class ContactDAO {
	
	// field
	@Autowired
	private JdbcTemplate template;
	private String sql;

	// method
	
	/**
	 * DB : CONTACT의 모든 정보를 가져온다.
	 * 
	 * @return DB : CONTACT의 모든 정보
	 */
	public List<Contact> selectListContact() {
		sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT";
		return template.query(sql, new BeanPropertyRowMapper<>(Contact.class));
	}
	
	/**
	 * DB : 선택한 CONTACT의 정보를 가져온다.
	 * 
	 * @param no 선택한 연락처
	 * @return DB : 선택한 CONTACT의 정보
	 */
	public Contact selectOneContact(long no){
		sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT WHERE NO = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<>(Contact.class), no);
	}
	
	/**
	 * DB : CONTACT에 연락처 추가
	 * 
	 * @param vo Contact 정보
	 * @return 등록 결과 : 오류 발생시 0 반환
	 */
	public int insertContact(Contact vo) {
		sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getTel());
				ps.setString(3, vo.getAddr());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getNote());
			}
		});
	}
	
	/**
	 * DB : CONTACT의 연락처 수정
	 * 
	 * @param vo Contact 정보
	 * @return 등록 결과 : 오류 발생시 0 반환
	 */
	public int updateContact(Contact vo) {
		sql = "UPDATE CONTACT SET NAME = ?, TEL = ?, ADDR = ?, EMAIL = ?, NOTE = ? WHERE NO = ?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getTel());
				ps.setString(3, vo.getAddr());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getNote());
				ps.setLong(6, vo.getNo());
			}
		});
	}
	
	/**
	 * DB : CONTACT의 연락처 삭제
	 * 
	 * @param no 삭제할 Contact의 NO
	 * @return 등록 결과 : 오류 발생시 0 반환
	 */
	public int deleteContact(long no) {
		sql = "DELETE FROM CONTACT WHERE NO = ?";
		return template.update(sql, no);
	}
}

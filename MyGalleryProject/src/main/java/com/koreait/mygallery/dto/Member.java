package com.koreait.mygallery.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * MEMBER TABLE의 DTO
 * 
 * @author ITSC
 */
@NoArgsConstructor
@Data
@ToString
public class Member {
	private long memberNo;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private String address;
	private Date regdate;
	private int state;
}

package com.koreait.mygallery.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
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

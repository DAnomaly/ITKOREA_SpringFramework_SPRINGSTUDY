package com.koreait.ajax.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Member {

	private long no;
	private String id;
	private String name;
	private String address;
	private String gender;
	private Date regdate;
	
}

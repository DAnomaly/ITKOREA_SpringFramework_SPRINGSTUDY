package com.koreait.mygallery.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GALLERY TABLE의 DTO
 * 
 * @author 박세환
 */
@NoArgsConstructor
@Data
public class Gallery {
	private long galleryNo;
	private String id;
	private String title;
	private String content;
	private Date postdate;
	private Date lastmodify;
	private String ip;
	private long hit;
	private String image;
}
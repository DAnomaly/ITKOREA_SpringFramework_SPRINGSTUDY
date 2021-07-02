package com.koreait.mygallery.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Gallery {
	private long galleryNo;
	private String id;
	private String title;
	private String content;
	private Date postdate;
	private Date lastmodify;
	private long hit;
	private String image;
	private int state;
}

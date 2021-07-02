package com.koreait.mygallery.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GalleryCom {
	private long galleryComNo;
	private long galleryNo;
	private String id;
	private String content;
	private Date postdate;
	private String ip;
}

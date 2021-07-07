package com.koreait.mygallery.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GALLERY_COM TABLE의 DTO
 * 
 * @author 박세환
 */
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

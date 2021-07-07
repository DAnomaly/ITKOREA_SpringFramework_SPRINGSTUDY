package com.koreait.mygallery.dto;

import com.koreait.mygallery.util.PagingUtils;

import lombok.Data;

/**
 * Paging 작업을 위한 DTO
 * 
 * @see PagingUtils
 * @author 박세환
 */
@Data
public class Page {
	private int page;
	private int totalRecord;
	private int recordPerPage;
	private int beginRecord;
	private int endRecord;
	private int totalPage;
	private int pagePerBlock;
	private int beginPage;
	private int endPage;
}
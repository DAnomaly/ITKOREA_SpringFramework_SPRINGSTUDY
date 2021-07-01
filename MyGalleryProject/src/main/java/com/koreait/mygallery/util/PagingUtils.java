package com.koreait.mygallery.util;

import com.koreait.mygallery.dto.Page;

/**
 * Page클래스를 생성하며<br>
 * 페이징 처리하여 String으로 반환해 주는 클래스
 * 
 * @see Page
 * @author 박세환
 */
public class PagingUtils {

	private PagingUtils(){}
	
	/**
	 * 패이지 당 Record의 개수 [기본값:10] 
	 */
	private static int recordPerPage = 10;
	/**
	 * 한번에 보여질 페이지 숫자의 개수 [기본값:5]
	 */
	private static int pagePerBlock = 5;
	
	/**
	 * 현재 페이지와 총 Record의 개수를 통해<br>
	 * Page 클래스를 생성하고 반환
	 * 
	 * @param nowpage 현재 페이지
	 * @param totalRecord 총 Record의 개수
	 * @return Page
	 */
	public static Page getPage(int nowpage, int totalRecord) {
		return getPage(nowpage, totalRecord, recordPerPage, pagePerBlock);
	}
	
	/**
	 * 기본값을 무시하고<br>
	 * Page 클래스를 생성하고 반환
	 * 
	 * @param nowpage 현재 페이지
	 * @param totalRecord 총 Record의 개수
	 * @param recordPerPage 페이지 당 Record의 개수
	 * @param pagePerBlock 페이지 숫자의 개수
	 * @return Page
	 */
	public static Page getPage(int nowpage, int totalRecord, int recordPerPage, int pagePerBlock) {
		// record
		int beginRecord = (nowpage - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		if(endRecord > totalRecord)
			endRecord = totalRecord;
		// page
		int totalPage = (totalRecord / recordPerPage) + (totalRecord % recordPerPage > 0 ? 1 : 0);
		int beginPage = ((nowpage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = beginPage + pagePerBlock - 1;
		if(totalPage < endPage) 
			endPage = totalPage;
		// new Page
		Page page = new Page();
		page.setPage(nowpage);
		page.setTotalRecord(totalRecord);
		page.setRecordPerPage(recordPerPage);
		page.setBeginRecord(beginRecord);
		page.setEndRecord(endRecord);
		page.setTotalPage(totalPage);
		page.setPagePerBlock(pagePerBlock);
		page.setBeginPage(beginPage);
		page.setEndPage(endPage);
		// return page
		return page;
	}
	
	/**
	 * ex) &lt; 1 2 3 4 5 &gt;<br>
	 * paging 처리를 하는 String을 생성 후 반환
	 * 
	 * @param path url 경로
	 * @param page getPage()로 받은 Page클래스
	 * @return paging
	 */
	public static String getPaging(String path, Page page) {
		StringBuilder sb = new StringBuilder();
		if(path.indexOf('?') != -1) {
			path = path + "&page=";
		} else {
			path = path + "?page=";
		}
		// LEFT (<)
		if(page.getBeginPage() == 1)
			sb.append("<a>&lt;</a>").append("&nbsp;");
		else
			sb.append("<a href='").append(path).append(page.getBeginPage() - 1).append("'>&lt;</a>").append("&nbsp;");
		// NUMBER (1 2 3 4 5)
		for (int p = page.getBeginPage(); p <= page.getEndPage(); p++) {
			if(p == page.getPage())
				sb.append("<a class='now-page'>").append(p).append("</a>").append("&nbsp;");
			else
				sb.append("<a href='").append(path).append(p).append("'>").append(p).append("</a>").append("&nbsp;");
		}
		// RIGHT (>)
		if(page.getEndPage() == page.getTotalPage())
			sb.append("<a>&gt;</a>");
		else
			sb.append("<a href='").append(path).append(page.getEndPage() + 1).append("'>&gt;</a>");
		
		return sb.toString();
	}

	/**
	 * ex) &lt; 1 2 3 4 5 &gt;<br>
	 * paging 처리를 하는 String을 생성 후 반환
	 * 
	 * @param path url 경로
	 * @param nowpage 현재 페이지
	 * @param totalRecord 총 record의 개수
	 * @return paging
	 */
	public static String getPaging(String path, int nowpage, int totalRecord) {
		Page page = getPage(nowpage, totalRecord);
		return getPaging(path, page);
	}
	
	/**
	 * ex) &lt; 1 2 3 4 5 &gt;<br>
	 * 기본값을 무시하고<br>
	 * paging 처리를 하는 String을 생성 후 반환
	 * 
	 * @param path url 경로
	 * @param nowpage 현재 페이지
	 * @param totalRecord 총 record의 개수
	 * @param recordPerPage 페이지 당 Record의 개수
	 * @param pagePerBlock 페이지 숫자의 개수
	 * @return paging
	 */
	public static String getPaging(String path, int nowpage, int totalRecord, int recordPerPage, int pagePerBlock) {
		Page page = getPage(nowpage, totalRecord, recordPerPage, pagePerBlock);
		return getPaging(path, page);
	}
}

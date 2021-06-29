package com.koreait.search.util;

import com.koreait.search.dto.Page;

public class PagingUtils {

	private static int recordPerPage = 5;
	private static int pagePerBlock = 3;
	
	public static Page getPage(int nowpage, int totalRecord) {
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
	
}

package com.koreait.ajax.util;

import com.koreait.ajax.dto.Page;

public class PagingUtils {

	public static Page getPage(int nowpage, int totalRecord) {
		Page page = new Page();
		int recordPerPage = 5;
		int beginRecord = (nowpage - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		if(endRecord > totalRecord)
			endRecord = totalRecord;
		int totalPage = (totalRecord / recordPerPage) + (totalRecord % recordPerPage > 0 ? 1 : 0);
		int pagePerBlock = 3;
		int beginPage = ((nowpage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = beginPage + pagePerBlock - 1;
		if(totalPage < endPage) 
			endPage = totalPage;
		page.setPage(nowpage);
		page.setTotalRecord(totalRecord);
		page.setRecordPerPage(recordPerPage);
		page.setBeginRecord(beginRecord);
		page.setEndRecord(endRecord);
		page.setTotalPage(totalPage);
		page.setPagePerBlock(pagePerBlock);
		page.setBeginPage(beginPage);
		page.setEndPage(endPage);
		
		return page;
	}
	
}
